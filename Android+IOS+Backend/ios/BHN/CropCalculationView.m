//
//  CropCalculationView.m
//  BHN
//
//  Created by William Grey on 8/9/14.
//  Copyright (c) 2014 BHN. All rights reserved.
//

#import "CropCalculationView.h"
#import "Utils.h"

@implementation CropCalculationView

- (id)initWithFrame:(CGRect)frame
{
    self = [super initWithFrame:frame];
    if (self) {
        // Initialization code
    }
    return self;
}

-(id) initWithCustomOptions:(CGFloat)y
{
    
    
    
    
    CGFloat winHeight = [[UIScreen mainScreen] bounds].size.height;
    CGFloat winWidth = [[UIScreen mainScreen] bounds].size.width;
    
    //passed
    CGFloat x = 0;
    
    //should be passed - take count of elements to decide number of columns
    NSArray *columnNames = [NSArray arrayWithObjects:@"N",@"P",@"K",@"Ca",@"Mg",@"K",nil];
    //should be passed  -- top and bottom label
    NSString *topHeader = @"Recommended Tissue Level";
    NSString *bottomHeader = @"(in percentages %)";
    NSString *labDataHeader = @"Enter Lab Data Foliar Analysis";
    
    //pass X and Y  , assume  0,0 now
    CGRect frameSize = CGRectMake(x, y, winWidth, winHeight*0.6);
    self = [super initWithFrame:frameSize];
    
    CGFloat offset = y;
    
    if(self){
        
        [self setBackgroundColor:[Utils colorWithHexString:@"e6e6e6"]];
         
        //
        UILabel *topLabel = [[UILabel alloc] initWithFrame:CGRectMake(x, offset, winWidth, 0.05*winHeight)];
        topLabel.textAlignment = NSTextAlignmentCenter;
        //[topLabel setBackgroundColor: [UIColor purpleColor]];
        [topLabel setText:topHeader];
        [self addSubview:topLabel];
        
        offset += 0.06*winHeight;
        
        UILabel *bottomLabel = [[UILabel alloc] initWithFrame:CGRectMake(x,offset,winWidth, 0.05*winHeight)];
        [bottomLabel setText:bottomHeader];
        bottomLabel.textAlignment = NSTextAlignmentCenter;
        //[bottomLabel setBackgroundColor:[UIColor purpleColor]];
        [self addSubview:bottomLabel];
        
        offset += 0.08*winHeight;
        
        //viewWidth and viewHeight corresponds to
        //equation for viewWidth considering left right gaps --> width  c(x)+(c+1)y= widthOfScreen
        
        //y
        CGFloat gapSize = 10;
        //c
        int columnCount = columnNames.count;

        CGFloat viewWidth = (winWidth - (columnCount+1)*gapSize)/columnCount;
        CGFloat viewHeight = 125;
        
        CGFloat columnOffset = gapSize;
        
        for (int i=0; i<columnCount; i++) {
            UIView *view = [[UIView alloc]initWithFrame:CGRectMake(columnOffset, offset, viewWidth, viewHeight)];
            
            UILabel *label = [[UILabel alloc] initWithFrame:CGRectMake(0, 0, viewWidth, viewHeight*0.4)];
            label.textColor = [UIColor whiteColor];
            label.text = [columnNames objectAtIndex:i];
            label.textAlignment = NSTextAlignmentCenter;
            
            [view addSubview:label];
            
            UITextView *textView = [[UITextView alloc] initWithFrame:CGRectMake(0, viewHeight*0.4, viewWidth, viewHeight*0.4)];
            [textView setBackgroundColor:[UIColor whiteColor]];
            //[textView setCenter:CGPointMake(0, viewHeight*0.4)];
            [textView setTextAlignment:NSTextAlignmentCenter];
            
            [view addSubview:textView];
            
            
            //UITextView *textView = [[UITextView] alloc] init
            [self addSubview:view];
            [view setBackgroundColor: [Utils colorWithHexString:@"2281bd"]];
            columnOffset+=(gapSize+viewWidth);
        }
        offset += viewHeight;
        
        UIView *labDataView = [[UIView alloc] initWithFrame:CGRectMake(x, offset, winWidth, winHeight*0.6-offset)];//remaining height for labDataView
        [labDataView setBackgroundColor: [Utils colorWithHexString:@"d2d3d4"]];
        
        CGFloat noffset = 5;
       
        UILabel *labDataLabel = [[UILabel alloc] initWithFrame:CGRectMake(x, noffset, winWidth, 0.05*winHeight)];
        labDataLabel.textAlignment = NSTextAlignmentCenter;
        //[labDataLabel setBackgroundColor: [UIColor purpleColor]];
        [labDataLabel setText:labDataHeader];
        [labDataLabel setTextColor: [Utils colorWithHexString:@"2281bd"]];
        [labDataView addSubview:labDataLabel];
        
        [self addSubview:labDataView];
        columnOffset = gapSize;
        
        for (int i=0; i<columnCount; i++) {
            
            UITextView *textView = [[UITextView alloc] initWithFrame:CGRectMake(columnOffset, labDataView.frame.size.height-viewHeight*0.4-1, viewWidth, viewHeight*0.4)];
            [textView setBackgroundColor:[UIColor whiteColor]];
            //[textView setCenter:CGPointMake(0, viewHeight*0.4)];
            [textView setTextAlignment:NSTextAlignmentCenter];
            
            [labDataView addSubview:textView];
            columnOffset+=(gapSize+viewWidth);
        }
        
    }
    //iphone, dismiss keyboard when touching outside of textfield
    UITapGestureRecognizer *tap = [[UITapGestureRecognizer alloc]
                                   initWithTarget:self
                                   action:@selector(dismissKeyboard)];
    
    
    
    [self addGestureRecognizer:tap];

    return self;
}

-(void)dismissKeyboard {
    [self endEditing:YES];
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
