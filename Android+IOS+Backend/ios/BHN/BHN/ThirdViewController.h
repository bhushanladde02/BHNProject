//
//  ThirdViewController.h
//  BHN
//
//  Created by William Grey on 6/25/14.
//  Copyright (c) 2014 BHN. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "MenuViewController.h"

@interface ThirdViewController : UIViewController<UITableViewDelegate, UITableViewDataSource>
{
    UITableView *tableView;
}

@property (nonatomic, retain) MenuViewController *menuVC;
@property (nonatomic, retain) UINavigationController *navController;

@end
