//
//  EnterDataViewController.h
//  BHN
//
//  Created by Rohit Kharat on 10/12/14.
//  Copyright (c) 2014 BHN. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "EnterAcresViewController.h"
#import "MenuViewController.h"

@interface EnterDataViewController : UITableViewController <UITextFieldDelegate>
{
    NSArray *blueLabels1;
    NSArray *blueLabels2;
    NSArray *recommendedLevels1;
    NSArray *recommendedLevels2;

    CGFloat winHeight;
    
    EnterAcresViewController *enterAcresVC;
}

@property (nonatomic, retain) NSString *cropType;
@property (nonatomic, retain) NSString *growthStage;
@property (nonatomic, retain) NSMutableArray *labData1;
@property (nonatomic, retain) NSMutableArray *labData2;

@property (nonatomic, retain) MenuViewController *menuVC;
@property (nonatomic, retain) UINavigationController *navController;

@end
