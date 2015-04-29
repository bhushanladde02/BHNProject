//
//  SavedCalculationsListViewController.h
//  BHN
//
//  Created by Rohit Kharat on 11/2/14.
//  Copyright (c) 2014 BHN. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "SaveCalculationViewController.h"

@interface SavedCalculationsListViewController : UIViewController <UITableViewDataSource, UITableViewDelegate>
{
    NSString *resultsDirectoryPath;
}
@property (nonatomic, retain) UITableView *savedCalcTableView;
@property (nonatomic, retain) NSMutableArray *listOfSavedFiles;
@property (nonatomic, retain) SaveCalculationViewController *savedCalculationVC;
@property (nonatomic, retain) NSMutableArray *resultsArray;

@end
