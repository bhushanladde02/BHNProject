//
//  TestingInstructionsListTableViewController.m
//  BHN
//
//  Created by Rohit Kharat on 11/3/14.
//  Copyright (c) 2014 BHN. All rights reserved.
//

#import "TestingInstructionsListTableViewController.h"

@interface TestingInstructionsListTableViewController ()

@end

@implementation TestingInstructionsListTableViewController

@synthesize testingInstructionsArray;

- (void)viewDidLoad {
    [super viewDidLoad];
    
    CGRect screenRect = [[UIScreen mainScreen] bounds];
    CGFloat screenWidth = screenRect.size.width;

    CGRect frame = CGRectMake(0, 0, screenWidth/2, 44);
    UILabel *label = [[UILabel alloc] initWithFrame:frame];
    label.font = [UIFont boldSystemFontOfSize:14.0];
    label.textAlignment = NSTextAlignmentCenter;
    label.textColor = [UIColor whiteColor];
    label.text = @"Testing Instructions";
    
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
}

-(void)back
{
    [self.navigationController popViewControllerAnimated:YES];
}

- (NSMutableArray*) getListOfTestingInstructions:(NSString*)productName fromDictionary:(NSDictionary*)productList  {
    
    
    NSMutableArray *valueArray = [productList valueForKey:productName];
   /* NSMutableArray* name =[[NSMutableArray alloc] init];
    for (NSDictionary *object in valueArray) {
        NSLog(@"value for %@",[object objectForKey:@"name"]);
        [name addObject: [object objectForKey:@"name"]];
    }*/
    
    return valueArray;
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

#pragma mark - Table view data source

- (NSInteger)numberOfSectionsInTableView:(UITableView *)tableView {
    // Return the number of sections.
    return 1;
}

- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section {
    // Return the number of rows in the section.
    return [self.testingInstructionsArray count];
}


- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath {
    
    static NSString *cellIdentifier = @"TestingInstrListViewCell";
    UITableViewCell *cell = [tableView dequeueReusableCellWithIdentifier:cellIdentifier];
    
    // If there is no cell to reuse, create a new one
    if(cell == nil)
    {
        cell = [[UITableViewCell alloc] initWithStyle:UITableViewCellStyleDefault reuseIdentifier:cellIdentifier];
    }
    
    cell.textLabel.text = [self.testingInstructionsArray objectAtIndex:indexPath.row];
    
    [cell setAccessoryType:UITableViewCellAccessoryDisclosureIndicator];
    cell.selectionStyle = UITableViewCellSelectionStyleNone;
    
    return cell;
}


/*
// Override to support conditional editing of the table view.
- (BOOL)tableView:(UITableView *)tableView canEditRowAtIndexPath:(NSIndexPath *)indexPath {
    // Return NO if you do not want the specified item to be editable.
    return YES;
}
*/

/*
// Override to support editing the table view.
- (void)tableView:(UITableView *)tableView commitEditingStyle:(UITableViewCellEditingStyle)editingStyle forRowAtIndexPath:(NSIndexPath *)indexPath {
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
- (void)tableView:(UITableView *)tableView moveRowAtIndexPath:(NSIndexPath *)fromIndexPath toIndexPath:(NSIndexPath *)toIndexPath {
}
*/

/*
// Override to support conditional rearranging of the table view.
- (BOOL)tableView:(UITableView *)tableView canMoveRowAtIndexPath:(NSIndexPath *)indexPath {
    // Return NO if you do not want the item to be re-orderable.
    return YES;
}
*/

/*
#pragma mark - Navigation

// In a storyboard-based application, you will often want to do a little preparation before navigation
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    // Get the new view controller using [segue destinationViewController].
    // Pass the selected object to the new view controller.
}
*/

@end
