//
//  SettingsViewController.m
//  BHN
//
//  Created by William Grey on 6/25/14.
//  Copyright (c) 2014 BHN. All rights reserved.
//

#import "SettingsViewController.h"
#import "FirstViewController.h"

@interface SettingsViewController ()

@end

@implementation SettingsViewController

- (id)initWithNibName:(NSString *)nibNameOrNil bundle:(NSBundle *)nibBundleOrNil
{
    self = [super initWithNibName:nibNameOrNil bundle:nibBundleOrNil];
    if (self) {
        // Custom initialization
    }
    return self;
}

- (void)viewDidLoad
{
    [super viewDidLoad];
    // Do any additional setup after loading the view.
    
    [self.view setBackgroundColor:[FirstViewController colorWithHexString:@"009e45"]];
    
    CGRect screenRect = [[UIScreen mainScreen] bounds];
    CGFloat screenWidth = screenRect.size.width;
    CGFloat screenHeight = screenRect.size.height;
    UIView *header = [[UIView alloc] initWithFrame:CGRectMake( 0 , 0, screenWidth, screenHeight*0.12)];
    CAGradientLayer *gradient = [CAGradientLayer layer];
    gradient.frame = header.bounds;
    gradient.colors = [NSArray arrayWithObjects:(id)[[FirstViewController colorWithHexString:@"009e45"] CGColor], (id)[[UIColor whiteColor] CGColor]    , nil];
    [header.layer insertSublayer:gradient atIndex:0];
    
    
    UIImageView *logo = [[UIImageView alloc] initWithImage:[UIImage imageNamed:@"icon.png"]];
    //hard coded -- change later
    logo.frame = CGRectMake(10,25,37,22);
    
    
    UIImageView *setting = [[UIImageView alloc] initWithImage:[UIImage imageNamed:@"settings.png"]];
    //hard coded -- change later
    setting.frame = CGRectMake(320-40,25,37,22);
    [setting sizeToFit];
    //logo.center = CGPointMake(10, );
    
    //NSLog([NSString stringWithFormat:@"%f",header.frame.size.height ]);
    //NSLog([NSString stringWithFormat:@"%f",(header.frame.size.height-22)/2]);
    
    [header addSubview:logo];
    [header addSubview:setting];
    
    UILabel *label = [[UILabel alloc] initWithFrame:CGRectMake(0, 0, 0, 0)];
    //[label setBackgroundColor:[UIColor blackColor]];
    [label setNumberOfLines:0];
    //[label setFont:[UIFont systemFontOfSize:36]];
    label.text = @"Account Setup";
    label.textColor = [UIColor blackColor];
    [label sizeToFit];
    
    [label setFrame:CGRectMake( (header.frame.size.width - label.frame.size.width)/2 , (header.frame.size.height - label.frame.size.height)/2, screenWidth, screenHeight*0.06)];
    
    //center label
    //[label setCenter:header.center]
    
    [header addSubview:label];
    
    
    UILabel *locationLabel = [[UILabel alloc] initWithFrame:CGRectMake(0, screenHeight*0.22, screenWidth, screenHeight*0.05)];
    locationLabel.text = @"Account Info";
    [locationLabel sizeToFit];
    [locationLabel setCenter:CGPointMake(screenWidth/2, screenHeight*0.22)];
    [self.view addSubview:locationLabel];

    
    
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
