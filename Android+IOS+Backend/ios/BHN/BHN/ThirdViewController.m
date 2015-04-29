//
//  ThirdViewController.m
//  BHN
//
//  Created by William Grey on 6/25/14.
//  Copyright (c) 2014 BHN. All rights reserved.
//

#import "ThirdViewController.h"
#import "Utils.h"
#import "MixingTableViewCell.h"

@interface ThirdViewController ()

@end

@implementation ThirdViewController

@synthesize menuVC, navController;

NSArray *tableData;

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
    
    CGFloat winHeight = [[UIScreen mainScreen] bounds].size.height;
    CGFloat winWidth = [[UIScreen mainScreen] bounds].size.width;

    
    //initiate table data
    //put mixing details here
    tableData = [[NSArray alloc] initWithObjects:@"CALCIUM",@"C-PHOS",@"GOLDEN GRO",@"SUPER PHOS / PHOS-MAX ",@"Z-PHOS",@"COMOL",@"FULVI PRO",@"ACTIVAL/TURF MICRO",@"CALCIUM",@"C-PHOS",@"GOLDEN GRO",@"SUPER PHOS",@"Z-PHOS",@"COMOL",@"FULVI PRO",@"ACTIVAL/TURF MICRO",@"CALCIUM",@"C-PHOS",@"GOLDEN GRO",@"SUPER PHOS",@"Z-PHOS",@"COMOL",@"FULVI PRO",@"ACTIVAL/TURF MICRO",nil];
    
    // Do any additional setup after loading the view.
    [self.view setBackgroundColor:[Utils colorWithHexString:@"e8e8e8"]];
    self.navigationController.navigationBar.translucent = NO;
    self.navigationController.navigationBar.tintColor = [Utils colorWithHexString:@"149c46"];
    self.navigationController.navigationBar.barTintColor = [Utils colorWithHexString:@"149c46"];
    
    
//    CGRect frame = CGRectMake(0, 0, winWidth, 44);
//    UILabel *label = [[UILabel alloc] initWithFrame:frame];
//    label.font = [UIFont boldSystemFontOfSize:14.0];
//    label.textAlignment = NSTextAlignmentCenter;
//    label.textColor = [UIColor whiteColor];
//    label.text = @"Product Information";
//    
//    self.navigationItem.titleView = label;
    
    tableView = [[UITableView alloc] initWithFrame:CGRectMake(0, 0, winWidth, winHeight)];
    tableView.backgroundColor = [Utils colorWithHexString:@"e8e8e8"];
    tableView.dataSource = self;
    tableView.rowHeight = 42;
    
    [self.view addSubview:tableView];
    [super viewDidLoad];
    
    //adding title and logo on top bar
    CGRect screenRect = [[UIScreen mainScreen] bounds];
    CGFloat screenWidth = screenRect.size.width;
    CGFloat screenHeight = screenRect.size.height;
    
    CGRect labelframe = CGRectMake(0, 0, screenWidth/2, 44);
    UILabel *titlelabel = [[UILabel alloc] initWithFrame:labelframe];
    titlelabel.font = [UIFont boldSystemFontOfSize:14.0];
    titlelabel.textAlignment = NSTextAlignmentCenter;
    titlelabel.textColor = [UIColor whiteColor];
    titlelabel.text = @"Mixing Guide";
    
    self.navigationItem.titleView = titlelabel;
    
    UIButton* BHNLogo = (UIButton *) [[UIImageView alloc] initWithImage:[UIImage imageNamed:@"header icons_44-01.png"]];
    UIBarButtonItem *BHNLogoItem = [[UIBarButtonItem alloc] initWithCustomView:BHNLogo];
    self.navigationItem.leftBarButtonItem = BHNLogoItem;
    
    self.navigationController.navigationItem.backBarButtonItem.tintColor = [UIColor whiteColor];
    self.navigationController.navigationBar.backItem.title = @"";

    //adding menu on top right corner
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
- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}


#pragma mark Table view methods

- (NSInteger)numberOfSectionsInTableView:(UITableView *)tableView {
    return 1;
}


// Customize the number of rows in the table view.
- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section {
    return [tableData count];
}


// Customize the appearance of table view cells.
- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath {
    
    static NSString *CellIdentifier = @"Cell";
    
    MixingTableViewCell *mcell = (MixingTableViewCell *) [tableView dequeueReusableCellWithIdentifier:CellIdentifier];
    if(mcell == nil){
          NSArray* topLevelObjects =[[NSBundle mainBundle ]loadNibNamed:@"MixingTableViewCell" owner:self options:nil];
        for (id currentObject in topLevelObjects) {
            if ([currentObject isKindOfClass:[MixingTableViewCell class]]) {
                mcell = (MixingTableViewCell *)currentObject;
                [mcell setFirstColumnName: [tableData objectAtIndex:indexPath.row]];
                [mcell setSecondColumnName:@"> 1.0"];
                
                [mcell.contentView.layer setBorderColor:[UIColor yellowColor].CGColor];
                //[mcell.contentView.layer setBorderWidth:1.0f];
                
                break;
            }
        }
        
    }
   
    /*
    UITableViewCell *cell = [tableView dequeueReusableCellWithIdentifier:CellIdentifier];
    if (cell == nil) {
        cell = [[UITableViewCell alloc] initWithStyle:UITableViewCellStyleDefault reuseIdentifier:CellIdentifier];
    }
    
    // Set up the cell...
    //cell.textLabel.font = [UIFont fontWithName:@"Helvetica" size:15];
    //cell.textLabel.text = [NSString	 stringWithFormat:@"Cell Row #%d", [indexPath row]];
    
    return cell;*/
    return mcell;

}

- (void)tableView:(UITableView *)tableView didSelectRowAtIndexPath:(NSIndexPath *)indexPath {
    // open a alert with an OK and cancel button
	NSString *alertString = [NSString stringWithFormat:@"Clicked on row #%d", [indexPath row]];
	UIAlertView *alert = [[UIAlertView alloc] initWithTitle:alertString message:@"" delegate:self cancelButtonTitle:@"Done" otherButtonTitles:nil];
	[alert show];
}

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





