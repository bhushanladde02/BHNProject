//
//  SaveCalculationViewController.h
//  BHN
//
//  Created by Rohit Kharat on 11/3/14.
//  Copyright (c) 2014 BHN. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface SaveCalculationViewController : UIViewController <UITableViewDelegate, UITableViewDataSource>

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

@end
