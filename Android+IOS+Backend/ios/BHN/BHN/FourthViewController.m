//
//  FourthViewController.m
//  BHN
//
//  Created by William Grey on 6/25/14.
//  Copyright (c) 2014 BHN. All rights reserved.
//

#import "FourthViewController.h"
#import "FirstViewController.h"
#import "CropCalculationView.h"
#import "ResultViewCell.h"
#import "TPKeyboardAvoidingScrollView.h"
#import "Utils.h"

@interface FourthViewController ()

@end

@implementation FourthViewController

- (id)initWithNibName:(NSString *)nibNameOrNil bundle:(NSBundle *)nibBundleOrNil
{
    self = [super initWithNibName:nibNameOrNil bundle:nibBundleOrNil];
    if (self) {
    }
    return self;
}

- (void)viewDidLoad
{
    [super viewDidLoad];
    
    CGFloat winHeight = [[UIScreen mainScreen] bounds].size.height;
    CGFloat winWidth = [[UIScreen mainScreen] bounds].size.width;
    
    
    TPKeyboardAvoidingScrollView* scrollView = [[TPKeyboardAvoidingScrollView alloc] initWithFrame:CGRectMake(0, 0, self.view.bounds.size.width, self.view.bounds.size.height)];
    scrollView.scrollEnabled = YES;
    //scrollView.pagingEnabled = YES;
    scrollView.showsVerticalScrollIndicator = YES;
    scrollView.showsHorizontalScrollIndicator = YES;
    scrollView.contentSize = CGSizeMake(winWidth, winHeight*2);
    //[self.view addSubview:scrollView];
    self.view = scrollView;

    
    // Custom initialization
    ResultViewCell *cropView = [[ResultViewCell alloc] initWithCustomOptions];
   [self.view addSubview:cropView];

     CropCalculationView *cropViewOne = [[CropCalculationView alloc] initWithCustomOptions:36];
    //[self.view addSubview:cropViewOne];
    
    
    //[self.view setBackgroundColor:[Utils colorWithHexString:@"009e45"]];
    // Do any additional setup after loading the view.
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

/*
#pragma mark - Navigation

// In a storyboard-based application, you will often want to do a little preparation before navigation
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender
{
    // Get the new view controller using [segue destinationViewController].
    // Pass the selected object to the new view controller.
}
*/

@end
