//
//  EnterDataViewController.m
//  BHN
//
//  Created by Rohit Kharat on 10/12/14.
//  Copyright (c) 2014 BHN. All rights reserved.
//

#import "EnterDataViewController.h"
#import "CustomCell.h"
#import "Utils.h"
#import "EnterAcresViewController.h"

@interface EnterDataViewController ()

@end

@implementation EnterDataViewController

@synthesize labData1, labData2, menuVC, navController;

- (id)initWithStyle:(UITableViewStyle)style
{
    self = [super initWithStyle:style];
    if (self) {
        // Custom initialization
    }
    return self;
}

- (void)viewDidLoad
{
    [super viewDidLoad];
    
    enterAcresVC = [[EnterAcresViewController alloc] init];
    
    // Uncomment the following line to preserve selection between presentations.
    // self.clearsSelectionOnViewWillAppear = NO;
    
    // Uncomment the following line to display an Edit button in the navigation bar for this view controller.
    // self.navigationItem.rightBarButtonItem = self.editButtonItem;
    
//    NSLog(@"self.cropType = %@", self.cropType);
//    NSLog(@"self.growthStage = %@", self.growthStage);
    
    [self.tableView registerNib:[UINib nibWithNibName:@"CustomCell" bundle:nil] forCellReuseIdentifier:@"Cell"];
    
    [self.tableView setSeparatorStyle:UITableViewCellSeparatorStyleNone];
    
    blueLabels1 = [NSArray arrayWithObjects:@"N",@"P",@"K",@"Ca",@"Mg",@"S",nil];
    blueLabels2 = [NSArray arrayWithObjects:@"Fe", @"Zn", @"Mn", @"Cu",@"B", nil];
    
    recommendedLevels1 = [NSArray arrayWithObjects:@"1.9",@"0.15", @"2.3", @"0.60", @"0.19", @"1.10",  nil];
    recommendedLevels2 = [NSArray arrayWithObjects:@"110",@"66", @"82", @"7", @"12",  nil];
    
    CGRect screenRect = [[UIScreen mainScreen] bounds];
    CGFloat screenWidth = screenRect.size.width;
    CGFloat screenHeight = screenRect.size.height;
    
    CGRect frame = CGRectMake(0, 0, screenWidth/2, 44);
    UILabel *label = [[UILabel alloc] initWithFrame:frame];
    label.font = [UIFont boldSystemFontOfSize:14.0];
    label.textAlignment = NSTextAlignmentCenter;
    label.textColor = [UIColor whiteColor];
    label.text = @"Product Calculator";
    
    self.navigationItem.titleView = label;
    
//    self.navigationController.navigationItem.backBarButtonItem.tintColor = [UIColor whiteColor];
//    self.navigationController.navigationBar.backItem.title = @"";

    //RK: added logo in navigation bar
//    UIButton* BHNLogo = (UIButton *) [[UIImageView alloc] initWithImage:[UIImage imageNamed:@"header icons_44-01.png"]];
//    UIBarButtonItem *BHNLogoItem = [[UIBarButtonItem alloc] initWithCustomView:BHNLogo];
//    self.navigationItem.leftBarButtonItem = BHNLogoItem;
    
    //RK: back button on top-left in navigation bar
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
    
    //iphone, dismiss keyboard when touching outside of textfield
    UITapGestureRecognizer *tap = [[UITapGestureRecognizer alloc]
                                   initWithTarget:self
                                   action:@selector(dismissKeyboard)];
    
    [self.view addGestureRecognizer:tap];
    
    UISwipeGestureRecognizer *mSwipeUpRecognizerRight = [[UISwipeGestureRecognizer alloc] initWithTarget:self action:@selector(switchWindowRight)];
    [mSwipeUpRecognizerRight setDirection:(UISwipeGestureRecognizerDirectionRight)];
    [[self view] addGestureRecognizer:mSwipeUpRecognizerRight];
    
    UISwipeGestureRecognizer *mSwipeUpRecognizerLeft = [[UISwipeGestureRecognizer alloc] initWithTarget:self action:@selector(switchWindowLeft)];
    [mSwipeUpRecognizerLeft setDirection:(UISwipeGestureRecognizerDirectionLeft)];
    [[self view] addGestureRecognizer:mSwipeUpRecognizerLeft];
    
    self.labData1 = [[NSMutableArray alloc] initWithCapacity:6];
    self.labData2 = [[NSMutableArray alloc] initWithCapacity:5];
    
    for (int i = 0; i<5; i++)
    {
        [self.labData1 addObject:@0];
        [self.labData2 addObject:@0];
    }
    
    for (int j = 5; j<6; j++)
    {
        [self.labData1 addObject:@0];
    }
    
    self.menuVC = [[MenuViewController alloc] init];
    self.navigationItem.rightBarButtonItem = [[UIBarButtonItem alloc] initWithImage:[UIImage imageNamed:@"menuIcon.png"] style:UIBarButtonItemStylePlain target:self action:@selector(showMenu)];
    [self.navigationItem.rightBarButtonItem setTintColor:[UIColor whiteColor]];
    
    self.navController = [[UINavigationController alloc] initWithRootViewController:self.menuVC];
    [self.menuVC.view setBackgroundColor:[UIColor whiteColor]];
    
    
}

-(void)showMenu
{
    [self presentViewController:self.navController animated:YES completion:nil];
}

-(void) switchWindowLeft
{
    
    enterAcresVC.cropType = self.cropType;
    enterAcresVC.growthStage = self.growthStage;
    enterAcresVC.labData1 = self.labData1;
    enterAcresVC.labData2 = self.labData2;
    
    [self.navigationController pushViewController:enterAcresVC animated:YES];
}

-(void) switchWindowRight
{
    [self.navigationController popToRootViewControllerAnimated:YES];
}

-(void)dismissKeyboard
{
    [self.view endEditing:YES];
}

-(void)back
{
    [self.navigationController popToRootViewControllerAnimated:YES];
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

#pragma mark - Table view data source

- (NSInteger)numberOfSectionsInTableView:(UITableView *)tableView
{
    return 2;
}

- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section
{
    if (section == 0)
    {
        return [blueLabels1 count];
    }
    
    return [blueLabels2 count];
}


- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath
{
    static NSString *cellIdentifier = @"Cell";
    CustomCell *cell = (CustomCell *)[tableView dequeueReusableCellWithIdentifier:cellIdentifier];
    
    // If there is no cell to reuse, create a new one
    if(cell == nil)
    {
        cell = [[CustomCell alloc] initWithStyle:UITableViewCellStyleDefault reuseIdentifier:cellIdentifier];
    }
    
    cell.valueField.delegate = self;
    [cell.valueField setKeyboardType:UIKeyboardTypeDecimalPad];
    cell.selectionStyle = UITableViewCellSelectionStyleNone;
    
    if (indexPath.section == 0)
    {
    // Configure the cell before it is displayed...
    cell.blueLabel.text = [blueLabels1 objectAtIndex:indexPath.row];
//        cell.recommendedLevelLabel.text = [recommendedLevels1 objectAtIndex:indexPath.row];
    }
    
    else
    {
        cell.blueLabel.text = [blueLabels2 objectAtIndex:indexPath.row];
//        cell.recommendedLevelLabel.text = [recommendedLevels2 objectAtIndex:indexPath.row];
    }
    
    if ((indexPath.row)%2 != 0) {
        cell.backgroundColor = [Utils colorWithHexString:@"e8e8e8"];
    }
    
    return cell;
}

-(CGFloat)tableView:(UITableView *)tableView heightForRowAtIndexPath:(NSIndexPath *)indexPath
{
    return 34;
}

- (CGFloat)tableView:(UITableView *)tableView heightForHeaderInSection:(NSInteger)section;
{
    if(section == 1)
    {
        return 34;
    }
    return UITableViewAutomaticDimension;
}

- (BOOL)textFieldShouldReturn:(UITextField *)textField
{
    [textField resignFirstResponder];
    return YES;
}

- (void) textFieldDidEndEditing:(UITextField *)textField
{
    // Get the cell in which the textfield is embedded
    id textFieldSuper = textField;
    while (![textFieldSuper isKindOfClass:[UITableViewCell class]]) {
        textFieldSuper = [textFieldSuper superview];
    }

    // Get that cell's index path
    NSIndexPath *indexPath = [self.tableView indexPathForCell:(UITableViewCell *)textFieldSuper];
    
    NSLog(@"did end editing row %ld value %@", (long)indexPath.row, textField.text);
    
    if (indexPath.section == 0)
        [self.labData1 replaceObjectAtIndex:indexPath.row withObject:textField.text];
    else
        [self.labData2 replaceObjectAtIndex:indexPath.row withObject:textField.text];

}

/*
// Override to support conditional editing of the table view.
- (BOOL)tableView:(UITableView *)tableView canEditRowAtIndexPath:(NSIndexPath *)indexPath
{
    // Return NO if you do not want the specified item to be editable.
    return YES;
}
*/

/*
// Override to support editing the table view.
- (void)tableView:(UITableView *)tableView commitEditingStyle:(UITableViewCellEditingStyle)editingStyle forRowAtIndexPath:(NSIndexPath *)indexPath
{
    if (editingStyle == UITableViewCellEditingStyleDelete) {
        // Delete the row from the data source
        [tableView deleteRowsAtIndexPaths:@[indexPath] withRowAnimation:UITableViewRowAnimationFade];
    } else if (editingStyle == UITableViewCellEditingStyleInsert) {
        // Create a new instance of the appropriate class, insert it into the array, and add a new row to the table view
    }   
}
*/

/*
// Override to support rearranging the table view.
- (void)tableView:(UITableView *)tableView moveRowAtIndexPath:(NSIndexPath *)fromIndexPath toIndexPath:(NSIndexPath *)toIndexPath
{
}
*/

/*
// Override to support conditional rearranging of the table view.
- (BOOL)tableView:(UITableView *)tableView canMoveRowAtIndexPath:(NSIndexPath *)indexPath
{
    // Return NO if you do not want the item to be re-orderable.
    return YES;
}
*/

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
