//
//  ResultViewCell.m
//  BHN
//
//  Created by Pradeep Chaudhari on 8/11/14.
//  Copyright (c) 2014 BHN. All rights reserved.
//

#import "ResultViewCell.h"
#import "Utils.h"

@implementation ResultViewCell

- (id)initWithFrame:(CGRect)frame
{
    self = [super initWithFrame:frame];
    if (self) {
        // Initialization code
    }
    return self;
}
-(id) initWithCustomOptions
{
        
    
    CGFloat winHeight = [[UIScreen mainScreen] bounds].size.height;
    CGFloat winWidth = [[UIScreen mainScreen] bounds].size.width;
    
    //passed
    CGFloat x = 0;
    CGFloat y = 36;
    
    //Pass
    NSArray *columnNames = [NSArray arrayWithObjects:@"N",@"P",@"K",@"Ca",@"Mg",@"S",nil];
    NSArray *columnNamesBig = [NSArray arrayWithObjects:@"SUPER NITRO",@"SUPER PHOS",@"SUPER K",@"Calcium",@"44 MAG",@"SULFUR"];
    NSString *topHeaderOne = @"Total Number of Gallons of";
    NSString *topHeaderTwo = @"HUMA GRO® Product Required";
    NSString *bottomHeader = @"Recommended Foliar Application Rate in ounces per Acre";
    
    //pass X and Y  , assume  0,0 now
    CGRect frameSize = CGRectMake(x, y, winWidth, winHeight*0.6);
    self = [super initWithFrame:frameSize];

    //c
    CGFloat gapWidth = 10;
    CGFloat viewWidth = (winWidth - ( columnNames.count + 1)*gapWidth) / columnNames.count;
    CGFloat viewHeight = viewWidth;
    
    CGFloat columnOffset = gapWidth;
    CGFloat offset = y;
    
    if (self) {
        
        
        [self setBackgroundColor: [Utils colorWithHexString:@"e6e6e6"]];
        
        // Initialization code
        for(int i=0;i<columnNames.count;i++){
            UIView *view = [[UIView alloc]initWithFrame:CGRectMake(columnOffset, offset, viewWidth, viewWidth)];
            [view setBackgroundColor: [Utils colorWithHexString:@"2281bd"]];
            columnOffset+=(gapWidth+viewWidth);
            
            
            UILabel *label = [[UILabel alloc] initWithFrame:CGRectMake(0, 0, viewWidth, viewWidth)];
            label.textColor = [UIColor whiteColor];
            label.text = [columnNames objectAtIndex:i];
            label.textAlignment = NSTextAlignmentCenter;
            [view addSubview:label];
            
            [self addSubview:view];
        }
        offset = offset + viewHeight;
        
        CGFloat middleViewHeight =  ((winHeight*0.6)-offset) * 0.5;
        UIView *middleView = [[UIView alloc]initWithFrame:CGRectMake(x, offset, winWidth,middleViewHeight)];
        [middleView setBackgroundColor: [Utils colorWithHexString:@"d2d3d4"]];
        
       
        
        CGFloat noffset = 0;
        
        UILabel *topLabelOne = [[UILabel alloc] initWithFrame:CGRectMake(x, noffset, winWidth, 0.03*winHeight)];
        topLabelOne.textAlignment = NSTextAlignmentCenter;
        //[topLabelOne setBackgroundColor: [UIColor purpleColor]];
        [topLabelOne setText:topHeaderOne];
        [topLabelOne setFont:[UIFont fontWithName:@"Helvetica" size:22]];
        [topLabelOne setTextColor: [Utils colorWithHexString:@"2281bd"]];
        [middleView addSubview:topLabelOne];
        
        noffset+=0.03*winHeight;
        
        UILabel *topLabelTwo = [[UILabel alloc] initWithFrame:CGRectMake(x, noffset, winWidth, 0.03*winHeight)];
        topLabelTwo.textAlignment = NSTextAlignmentCenter;
        [topLabelTwo setBackgroundColor: [UIColor purpleColor]];
        [topLabelTwo setText:topHeaderTwo];
        [topLabelTwo setFont:[UIFont fontWithName:@"Helvetica" size:22]];
        [topLabelTwo setTextColor: [Utils colorWithHexString:@"2281bd"]];
        [middleView addSubview:topLabelTwo];
        
        noffset+=0.03*winHeight;
        
        columnOffset=gapWidth;
        
        
        for(int i=0;i<columnNames.count;i++){
            UITextView *view = [[UITextView alloc]initWithFrame:CGRectMake(columnOffset, middleViewHeight-viewHeight, viewWidth, viewHeight)];
            columnOffset+=(gapWidth+viewWidth);
            
            [middleView addSubview:view];
        }
        
        [self addSubview:middleView];
        
    }

    return self;
}

/*
// Only override drawRect: if you perform custom drawing.
// An empty implementation adversely affects performance during animation.
- (void)drawRect:(CGRect)rect
{
    // Drawing code
}
*/

@end
