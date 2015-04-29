//
//  MenuViewController.m
//  BHN
//
//  Created by Rohit Kharat on 11/1/14.
//  Copyright (c) 2014 BHN. All rights reserved.
//

#import "MenuViewController.h"
#import "Utils.h"
#import "SavedCalculationsListViewController.h"
#import "TestingInstructionsListTableViewController.h"

@interface MenuViewController ()

@end

@implementation MenuViewController

@synthesize menuTableView;

- (void)viewDidLoad {
    [super viewDidLoad];
    
    self.navigationController.navigationBar.barTintColor = [Utils colorWithHexString:@"149c46"];
    //    self.navigationItem.leftBarButtonItem = [[UIBarButtonItem alloc] initWithBarButtonSystemItem:UIBarButtonSystemItemCancel target:self action:@selector(cancelAction)];
    self.navigationItem.rightBarButtonItem = [[UIBarButtonItem alloc] initWithTitle:@"Done" style:UIBarButtonItemStylePlain target:self action:@selector(doneAction)];
    [self.navigationItem.rightBarButtonItem setTintColor:[UIColor whiteColor]];
    
    //    self.navigationItem.rightBarButtonItem = [[UIBarButtonItem alloc] initWithBarButtonSystemItem:UIBarButtonSystemItemDone target:self action:@selector(doneAction)];
    
    self.menuTableView = [[UITableView alloc] initWithFrame:CGRectMake(0, 0, self.view.frame.size.width, self.view.frame.size.height) style:UITableViewStyleGrouped];
    [self.menuTableView setDelegate:self];
    [self.menuTableView setDataSource:self];
    [self.view addSubview:self.menuTableView];
    
    NSURL *url = [[NSURL alloc]initWithString:@"http://104.130.240.26:8080/bhn/service/testinstr/"];
    NSURLRequest *request = [NSURLRequest requestWithURL:url];
    [NSURLConnection sendAsynchronousRequest:request queue:[NSOperationQueue mainQueue] completionHandler:^(NSURLResponse *response, NSData *data, NSError *error)
     {
         if (data.length > 0 && error == nil)
         {
             NSDictionary *dictionary = [NSJSONSerialization JSONObjectWithData:data options:0 error:nil];
             //             self.testingInstructionsArray = [self getListOfTestingInstructions:@"plantName" fromDictionary:dictionary];
             self.testingInstructionsArray = [dictionary valueForKey:@"plantName"];
         }
     }];
    

    
}

- (void)doneAction {
    
    [self dismissViewControllerAnimated:YES completion:nil];
    
}

-(NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section
{
    return 1;
}

- (NSInteger)numberOfSectionsInTableView:(UITableView *)tableView
{
    return 2;
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
    
    if (indexPath.section == 0)
        cell.textLabel.text = @"Saved Calculations";
    else
        cell.textLabel.text = @"Testing Instructions";
    
    [cell setAccessoryType:UITableViewCellAccessoryDisclosureIndicator];
    cell.selectionStyle = UITableViewCellSelectionStyleNone;
    
    return cell;
}

- (void)tableView:(UITableView *)tableView didSelectRowAtIndexPath:(NSIndexPath *)indexPath
{
    if (indexPath.section == 0)
    {
        SavedCalculationsListViewController *savedCalculationsVC = [[SavedCalculationsListViewController alloc] init];
        [self.navigationController pushViewController:savedCalculationsVC animated:YES];
    }
    
    if (indexPath.section == 1)
    {
        TestingInstructionsListTableViewController *testingListVC = [[TestingInstructionsListTableViewController alloc] init];
        testingListVC.testingInstructionsArray = self.testingInstructionsArray;
        [self.navigationController pushViewController:testingListVC animated:YES];
    }
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
