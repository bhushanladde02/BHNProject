//
//  EnterAcresViewController.h
//  BHN
//
//  Created by Rohit Kharat on 10/12/14.
//  Copyright (c) 2014 BHN. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "CropDetails.h"
#import "ResultsViewController.h"
#import "MenuViewController.h"

@interface EnterAcresViewController : UIViewController <UITextFieldDelegate>
{
    UILabel *EnterAcresLabel;
    UITextField *acresTextField;
    UIButton *getResultsButton;
    
    NSMutableArray *nutritionalDeficiency;
    NSMutableArray *foliarApplicationRate;
    NSArray *cropDetails;
    NSArray *cropFactor;
    
    BOOL dataCreated;
    
    ResultsViewController *resultsVC;
}

@property (nonatomic, retain) NSString *cropType;
@property (nonatomic, retain) NSString *growthStage;
@property (nonatomic, retain) NSMutableArray *labData1;
@property (nonatomic, retain) NSMutableArray *labData2;
@property (nonatomic, retain) NSString *acres;
@property (nonatomic, retain) NSMutableArray *labData;
@property (nonatomic, retain) NSMutableArray *results;

@property (nonatomic, strong) NSDictionary *BHNData;

@property (nonatomic, retain) MenuViewController *menuVC;
@property (nonatomic, retain) UINavigationController *navController;


@end
