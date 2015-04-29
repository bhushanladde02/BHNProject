//
//  MixingTableViewCell.m
//  BHN
//
//  Created by William Grey on 7/16/14.
//  Copyright (c) 2014 BHN. All rights reserved.
//

#import "MixingTableViewCell.h"
#import "FirstViewController.h"
#import "Utils.h"

@implementation MixingTableViewCell

- (void)awakeFromNib
{
    //self.backgroundColor = [Utils colorWithHexString:@"a7a9ab"];
    //self.firstColumn.backgroundColor = [Utils colorWithHexString:@"e6e6e6"];
    //self.secondColumn.backgroundColor = [Utils colorWithHexString:@"e6e6e6"];
}

- (void)setSelected:(BOOL)selected animated:(BOOL)animated
{
    [super setSelected:selected animated:animated];
    // Configure the view for the selected state
}

-(void) setFirstColumnName:(NSString *)firstName
{
    self.firstColumn.text = firstName;
}

-(void) setSecondColumnName:(NSString *)secondName
{
    self.secondColumn.text = secondName;
}

@end
