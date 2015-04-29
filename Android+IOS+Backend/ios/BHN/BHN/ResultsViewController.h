//
//  ResultsViewController.h
//  BHN
//
//  Created by Rohit Kharat on 10/13/14.
//  Copyright (c) 2014 BHN. All rights reserved.
//

#import <UIKit/UIKit.h>
#import <MessageUI/MessageUI.h>
#import "CropDetails.h"
#import "MenuViewController.h"

@interface ResultsViewController : UIViewController <UITableViewDelegate, UITableViewDataSource, MFMailComposeViewControllerDelegate>
{
    UITableView *resultsTable;
    NSArray *blueLabels;
    NSArray *productLabels;
    UILabel *titleLabel;
    UILabel *subtitleLabel;
    
    CGFloat screenWidth, screenHeight;
    UIButton *saveButton;
    UIButton *shareButton;

}

@property (nonatomic, retain) NSMutableArray *results;

@property (nonatomic, retain) MenuViewController *menuVC;
@property (nonatomic, retain) UINavigationController *navController;

@end
