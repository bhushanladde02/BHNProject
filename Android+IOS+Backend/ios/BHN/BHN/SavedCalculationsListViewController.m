//
//  SavedCalculationsListViewController.m
//  BHN
//
//  Created by Rohit Kharat on 11/2/14.
//  Copyright (c) 2014 BHN. All rights reserved.
//

#import "SavedCalculationsListViewController.h"

@interface SavedCalculationsListViewController ()

@end

@implementation SavedCalculationsListViewController

@synthesize savedCalcTableView, listOfSavedFiles, savedCalculationVC, resultsArray;

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view.
    
    [self.view setBackgroundColor:[UIColor whiteColor]];
    
    CGRect screenRect = [[UIScreen mainScreen] bounds];
    CGFloat screenWidth = screenRect.size.width;

    CGRect frame = CGRectMake(0, 0, screenWidth/2, 44);
    UILabel *label = [[UILabel alloc] initWithFrame:frame];
    label.font = [UIFont boldSystemFontOfSize:14.0];
    label.textAlignment = NSTextAlignmentCenter;
    label.textColor = [UIColor whiteColor];
    label.text = @"Saved Calculations";
    
    self.navigationItem.titleView = label;
    
    UIImage *backButtonImage = [UIImage imageNamed:@"misc_BACK ARROW.png"];
    UIBarButtonItem *barButtonItem = [[UIBarButtonItem alloc]init];
    barButtonItem.image = backButtonImage;
    self.navigationItem.backBarButtonItem.image = backButtonImage;
    // barButtonItem.image = backButtonImage;
    
    UIBarButtonItem *backButton = [[UIBarButtonItem alloc]
                                   initWithImage:backButtonImage
                                   style:UIBarButtonItemStylePlain
                                   target:self
                                   action:@selector(back)];
    
    self.navigationItem.backBarButtonItem = backButton;
    
    [self.navigationItem setLeftBarButtonItem:backButton animated:YES];
    self.navigationItem.backBarButtonItem.tintColor = [UIColor whiteColor];
    
    self.savedCalcTableView = [[UITableView alloc] initWithFrame:CGRectMake(0, 0, self.view.frame.size.width, self.view.frame.size.height) style:UITableViewStyleGrouped];
    [self.savedCalcTableView setDelegate:self];
    [self.savedCalcTableView setDataSource:self];
    [self.view addSubview:self.savedCalcTableView];
    
    self.listOfSavedFiles = [self getSavedFiles];
    
}

-(void)back
{
    [self.navigationController popViewControllerAnimated:YES];
}

-(NSMutableArray *)getSavedFiles
{    
    int count;
    
    //get the documents directory:
    NSArray *paths = NSSearchPathForDirectoriesInDomains
    (NSDocumentDirectory, NSUserDomainMask, YES);
    NSString *documentsDirectory = [paths objectAtIndex:0];
    
    resultsDirectoryPath = [documentsDirectory stringByAppendingPathComponent:@"/results"];
    
    NSMutableArray *directoryContent = [NSMutableArray arrayWithArray:[[NSFileManager defaultManager] contentsOfDirectoryAtPath:resultsDirectoryPath error:NULL]];
    
    for (count = 0; count < (int)[directoryContent count]; count++)
    {
        NSLog(@"File %d: %@", (count + 1), [directoryContent objectAtIndex:count]);
    }
    
    return directoryContent;
}

-(NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section
{
    return [self.listOfSavedFiles count];
}

- (NSInteger)numberOfSectionsInTableView:(UITableView *)tableView
{
    return 1;
}

-(UITableViewCell*)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath
{
    static NSString *cellIdentifier = @"MenuViewCell";
    UITableViewCell *cell = [tableView dequeueReusableCellWithIdentifier:cellIdentifier];
    
    // If there is no cell to reuse, create a new one
    if(cell == nil)
    {
        cell = [[UITableViewCell alloc] initWithStyle:UITableViewCellStyleDefault reuseIdentifier:cellIdentifier];
    }
    
    cell.textLabel.text = [self.listOfSavedFiles objectAtIndex:indexPath.row];
    [cell setAccessoryType:UITableViewCellAccessoryDisclosureIndicator];
    cell.selectionStyle = UITableViewCellSelectionStyleNone;
    
    return cell;
}

- (void)tableView:(UITableView *)tableView didSelectRowAtIndexPath:(NSIndexPath *)indexPath
{
    UITableViewCell *cell = [tableView cellForRowAtIndexPath:indexPath];
    NSString *fileName = cell.textLabel.text;

    NSString *filePath = [resultsDirectoryPath stringByAppendingPathComponent:[NSString stringWithFormat:@"%@",fileName]];
    NSData *data = [NSData dataWithContentsOfFile:filePath];
    NSDictionary *json = [NSJSONSerialization JSONObjectWithData:data options:kNilOptions error:nil];
    
    self.savedCalculationVC = [[SaveCalculationViewController alloc] init];
    self.resultsArray = [json objectForKey:@"results"];
    self.savedCalculationVC.results = self.resultsArray;
    [self.navigationController pushViewController:self.savedCalculationVC animated:YES];
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

/*
#pragma mark - Navigation

// In a storyboard-based application, you will often want to do a little preparation before navigation
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    // Get the new view controller using [segue destinationViewController].
    // Pass the selected object to the new view controller.
}
*/

@end
