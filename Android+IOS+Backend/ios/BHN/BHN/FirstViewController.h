//
//  FirstViewController.h
//  BHN
//
//  Created by William Grey on 6/25/14.
//  Copyright (c) 2014 BHN. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "EnterDataViewController.h"
#import "MenuViewController.h"

@interface FirstViewController : UIViewController<UIGestureRecognizerDelegate, UIPickerViewDelegate, UIPickerViewDataSource>
{
    UIActionSheet *actionSheet;
    UIButton *doneBtn1, *doneBtn2, *doneBtn3;
    EnterDataViewController *enterDataVC;
    
}

-(void)showAddLocation:(id)sender;

@property (nonatomic, retain) NSMutableArray *locationsArray;
@property (nonatomic, retain) NSMutableArray *cropTypeArray;
@property (nonatomic, retain) NSMutableArray *growthStageArray;

@property (nonatomic, retain) NSString *location;
@property (nonatomic, retain) NSString *cropType;
@property (nonatomic, retain) NSString *growthStage;

@property (nonatomic, retain) UILabel *locationLabel;
@property (nonatomic, retain) UILabel *cropTypeLabel;
@property (nonatomic, retain) UILabel *growthStageLabel;

@property (nonatomic, retain) UIButton *locationBtn;
@property (nonatomic, retain) UIButton *cropTypeBtn;
@property (nonatomic, retain) UIButton *growthStageBtn;
@property (nonatomic, retain) UIButton *addLocationBtn;

@property (nonatomic, retain) MenuViewController *menuVC;
@property (nonatomic, retain) UINavigationController *navController;

@end
