//
//  MenuViewController.h
//  BHN
//
//  Created by Rohit Kharat on 11/1/14.
//  Copyright (c) 2014 BHN. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface MenuViewController : UIViewController <UITableViewDataSource, UITableViewDelegate>

@property (nonatomic, retain) UITableView *menuTableView;
@property (nonatomic, retain) NSMutableArray *testingInstructionsArray;
@end
