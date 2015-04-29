//
//  SaveCalculationViewController.m
//  BHN
//
//  Created by Rohit Kharat on 11/3/14.
//  Copyright (c) 2014 BHN. All rights reserved.
//

#import "SaveCalculationViewController.h"
#import "Utils.h"
#import "ResultsTableViewCell.h"

@interface SaveCalculationViewController ()

@end

@implementation SaveCalculationViewController

@synthesize results;

- (id)initWithNibName:(NSString *)nibNameOrNil bundle:(NSBundle *)nibBundleOrNil
{
    self = [super initWithNibName:nibNameOrNil bundle:nibBundleOrNil];
    if (self) {
        // Custom initialization
    }
    return self;
}

- (void)viewDidLoad
{
    [super viewDidLoad];
    
    CGRect screenRect = [[UIScreen mainScreen] bounds];
    screenWidth = screenRect.size.width;
    screenHeight = screenRect.size.height;
    
    CGRect frame = CGRectMake(0, 0, screenWidth/2, 44);
    UILabel *label = [[UILabel alloc] initWithFrame:frame];
    label.font = [UIFont boldSystemFontOfSize:14.0];
    label.textAlignment = NSTextAlignmentCenter;
    label.textColor = [UIColor whiteColor];
    label.text = @"Product Calculator";
    
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
    
    [self.view setBackgroundColor:[Utils colorWithHexString:@"e8e8e8"]];
    
    resultsTable = [[UITableView alloc] initWithFrame:CGRectMake(0, 0, screenWidth, screenHeight*0.77) style:UITableViewStylePlain];
    [resultsTable registerNib:[UINib nibWithNibName:@"ResultsTableViewCell" bundle:nil] forCellReuseIdentifier:@"ResultCell"];
    [resultsTable setSeparatorStyle:UITableViewCellSeparatorStyleNone];
    [resultsTable setDelegate:self];
    [resultsTable setDataSource:self];
    [resultsTable setScrollEnabled:NO];
    [self.view addSubview:resultsTable];
    
    blueLabels = [NSArray arrayWithObjects:@"N",@"P",@"K",@"Ca",@"Mg",@"S",@"Fe", @"Zn", @"Mn", @"Cu",@"B", nil];
    productLabels = [NSArray arrayWithObjects:@"SUPER NITRO®",@"SUPER PHOS®",@"SUPER K®",@"CALCIUM®",@"44 MAG®",@"SULFUR®",@"IRON®", @"Z-MAX®", @"MANGANESE®", @"COPPER®",@"BORON®", nil];
    
//    titleLabel = [[UILabel alloc] initWithFrame:CGRectMake(0, 0, screenWidth*0.9, screenHeight*0.2)];
//    titleLabel.text = @"Total Number of Gallons of HUMA GRO® Product Required";
//    titleLabel.textColor = [Utils colorWithHexString:@"447fc2"];
//    [titleLabel setTextAlignment:NSTextAlignmentCenter];
//    [titleLabel setCenter:CGPointMake(screenWidth/2, screenHeight*0.12)];
//    titleLabel.font = [UIFont systemFontOfSize:screenHeight*0.025];
//    [titleLabel setLineBreakMode:NSLineBreakByWordWrapping];
//    [titleLabel setNumberOfLines:0];
//    [titleLabel sizeToFit];
//    [self.view addSubview:titleLabel];
    
    subtitleLabel = [[UILabel alloc] initWithFrame:CGRectMake(0, 0, screenWidth*0.9, screenHeight*0.2)];
    subtitleLabel.text = @"Recommended Foliar Application Rate are given in ounces per Acre";
    subtitleLabel.textColor = [UIColor blackColor];
    [subtitleLabel setTextAlignment:NSTextAlignmentCenter];
    [subtitleLabel setCenter:CGPointMake(screenWidth/2, screenHeight*0.9)];
    subtitleLabel.font = [UIFont systemFontOfSize:screenHeight*0.02];
    [subtitleLabel setLineBreakMode:NSLineBreakByWordWrapping];
    [subtitleLabel setNumberOfLines:0];
    [subtitleLabel sizeToFit];
    [self.view addSubview:subtitleLabel];
    
}

-(void)back
{
    [self.navigationController popViewControllerAnimated:YES];
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

- (NSInteger)numberOfSectionsInTableView:(UITableView *)tableView
{
    return 1;
}

- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section
{
    return [blueLabels count];
}

- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath
{
    static NSString *cellIdentifier = @"ResultCell";
    ResultsTableViewCell *cell = (ResultsTableViewCell *)[tableView dequeueReusableCellWithIdentifier:cellIdentifier];
    
    // If there is no cell to reuse, create a new one
    if(cell == nil)
    {
        cell = [[ResultsTableViewCell alloc] initWithStyle:UITableViewCellStyleDefault reuseIdentifier:cellIdentifier];
    }
    
    cell.selectionStyle = UITableViewCellSelectionStyleNone;
    
    cell.blueLabel.text = [blueLabels objectAtIndex:indexPath.row];
    cell.productLabel.text = [productLabels objectAtIndex:indexPath.row];
    cell.resultLabel.text = [[self.results objectAtIndex:indexPath.row] stringValue];
    
    //alternate rows should be grey in color
    if ((indexPath.row)%2 != 0) {
        cell.backgroundColor = [Utils colorWithHexString:@"e8e8e8"];
    }
    
    return cell;
}

-(CGFloat)tableView:(UITableView *)tableView heightForRowAtIndexPath:(NSIndexPath *)indexPath
{
    return 34;
}

//- (CGFloat)tableView:(UITableView *)tableView heightForFooterInSection:(NSInteger)section
//{
//    return screenHeight*0.2;
//}

/*
 #pragma mark - Navigation
 
 // In a storyboard-based application, you will often want to do a little preparation before navigation
 - (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender
 {
 // Get the new view controller using [segue destinationViewController].
 // Pass the selected object to the new view controller.
 }
 */

@end