//
//  MixingTableViewCell.h
//  BHN
//
//  Created by William Grey on 7/16/14.
//  Copyright (c) 2014 BHN. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface MixingTableViewCell : UITableViewCell
@property (weak, nonatomic) IBOutlet UILabel *firstColumn;
@property (weak, nonatomic) IBOutlet UILabel *secondColumn;


-(void) setFirstColumnName:(NSString *)firstName;
-(void) setSecondColumnName:(NSString *)secondName;

@end
