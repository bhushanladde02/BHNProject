//
//  SecondViewController.h
//  BHN
//
//  Created by William Grey on 6/25/14.
//  Copyright (c) 2014 BHN. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "MenuViewController.h"

@interface SecondViewController : UIViewController<UITableViewDelegate, UITableViewDataSource, UIDocumentInteractionControllerDelegate>
{
   UITableView *macronutrients;
   UITableView *micronutrients;
   UITableView *soilFertility;
   UITableView *plantGrowthManagement;
   UITableView *zeroResidueCrop;
   UITableView *carbonRichOrganicAcids;
   UIDocumentInteractionController *documentInteractionController;
}


@property (nonatomic, retain) MenuViewController *menuVC;
@property (nonatomic, retain) UINavigationController *navController;

@end

