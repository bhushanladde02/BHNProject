//
//  FirstViewController.m
//  BHN
//
//  Created by William Grey on 6/25/14.
//  Copyright (c) 2014 BHN. All rights reserved.
//

#import "FirstViewController.h"
#import "SecondViewController.h"
#import "EnterDataViewController.h"
#import "Utils.h"
#import "AppDelegate.h"

@interface FirstViewController ()

@property (strong, nonatomic) UIView *locationContainerView;
@property (strong, nonatomic) UIView *cropTypeContainerView;
@property (strong, nonatomic) UIView *growthStageContainerView;

@property (strong, nonatomic) NSLayoutConstraint *locationContainerVerticalConstraint;
@property (strong, nonatomic) NSLayoutConstraint *cropTypeContainerVerticalConstraint;
@property (strong, nonatomic) NSLayoutConstraint *growthStageContainerVerticalConstraint;

@property (strong, nonatomic) UIPickerView *locationPicker;
@property (strong, nonatomic) UIPickerView *cropTypePicker;
@property (strong, nonatomic) UIPickerView *growthStagePicker;

@end

@implementation FirstViewController

@synthesize locationsArray, cropTypeArray, growthStageArray, location, cropType, growthStage, locationLabel, cropTypeLabel, growthStageLabel, locationBtn, cropTypeBtn, growthStageBtn, addLocationBtn, menuVC, navController;

- (void)viewDidLoad
{
    [super viewDidLoad];
    
     enterDataVC = [[EnterDataViewController alloc] init];
    
    //code for adding swipe arrow:
    UIImage *swipeButtonImage = [UIImage imageNamed:@"arrow-07.png"];
    UIImageView *swipeImageView = [[UIImageView alloc] initWithFrame:CGRectMake(0, 0, self.view.frame.size.width*0.5, 50)];
    swipeImageView.contentMode = UIViewContentModeScaleAspectFit;
    [swipeImageView setImage:swipeButtonImage];
    [swipeImageView setCenter:CGPointMake(self.view.frame.size.width/2, self.view.frame.size.height*0.7)];
    [self.view addSubview:swipeImageView];
    
    //RK: Set up views and pickers
    [self setUpContainerView];
    [self setUpPickers];
    [self setUpToolbar];
    
    self.locationsArray = [[NSMutableArray alloc]initWithObjects:@"Location 1", @"Location 2", @"Location 3", nil];
    self.cropTypeArray = [[NSMutableArray alloc]initWithObjects:@"Almonds", @"Apples", @"Cantaloupe", @"Chilipeppers",@"Corn",@"Cotton",@"Cucumbers",@"DryEdibleBeans",@"Grapes",@"Onions",@"Oranges",@"PeachNectarine",@"Pecans",@"Potato",@"Rice",@"Soybeans",@"Tomato",@"Watermelon",@"Wheat", nil];
    self.growthStageArray = [[NSMutableArray alloc]initWithObjects:@"1", @"2", @"3", @"4", nil];
    
    [self.locationLabel setText:@"Select"];
    [self.cropTypeLabel setText:@"Select"];
    [self.growthStageLabel setText:@"Select"];
    
    //----------------
    
    [self.view setBackgroundColor:[Utils colorWithHexString:@"e8e8e8"]];
    self.navigationController.navigationBar.translucent = NO;
//    self.navigationController.navigationBar.tintColor = [Utils colorWithHexString:@"149c46"];
    self.navigationController.navigationBar.barTintColor = [Utils colorWithHexString:@"149c46"];
    
    CGRect screenRect = [[UIScreen mainScreen] bounds];
    CGFloat screenWidth = screenRect.size.width;
    CGFloat screenHeight = screenRect.size.height;
    
    CGRect frame = CGRectMake(0, 0, screenWidth/2, 44);
    UILabel *label = [[UILabel alloc] initWithFrame:frame];
    label.font = [UIFont boldSystemFontOfSize:14.0];
    label.textAlignment = NSTextAlignmentCenter;
    label.textColor = [UIColor whiteColor];
    label.text = @"Product Calculator";
    
    self.navigationItem.titleView = label;
    
    //RK: added logo in navigation bar
    UIButton* BHNLogo = (UIButton *) [[UIImageView alloc] initWithImage:[UIImage imageNamed:@"header icons_44-01.png"]];
    UIBarButtonItem *BHNLogoItem = [[UIBarButtonItem alloc] initWithCustomView:BHNLogo];
    self.navigationItem.leftBarButtonItem = BHNLogoItem;
    
    self.navigationController.navigationItem.backBarButtonItem.tintColor = [UIColor whiteColor];
    self.navigationController.navigationBar.backItem.title = @"";

    
    
    
    
    /* UIView *header = [[UIView alloc] initWithFrame:CGRectMake( 0 , 0, screenWidth, screenHeight*0.12)];
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
     
     
     UITapGestureRecognizer *singleTapSettings = [[UITapGestureRecognizer alloc] initWithTarget:self action:@selector(tapDetectedSettings)];
     singleTapSettings.numberOfTapsRequired = 1;
     setting.userInteractionEnabled = YES;
     [setting addGestureRecognizer:singleTapSettings];
     
     
     
     //logo.center = CGPointMake(10, );
     
     //NSLog([NSString stringWithFormat:@"%f",header.frame.size.height ]);
     //NSLog([NSString stringWithFormat:@"%f",(header.frame.size.height-22)/2]);
     
     [header addSubview:logo];
     [header addSubview:setting];
     
     UILabel *label = [[UILabel alloc] initWithFrame:CGRectMake(0, 0, 0, 0)];
     //[label setBackgroundColor:[UIColor blackColor]];
     [label setNumberOfLines:0];
     //[label setFont:[UIFont systemFontOfSize:36]];
     label.text = @"Nutrient Sufficiency ";
     label.textColor = [UIColor blackColor];
     [label sizeToFit];
     
     [label setFrame:CGRectMake( (header.frame.size.width - label.frame.size.width)/2 , (header.frame.size.height - label.frame.size.height)/2, screenWidth, screenHeight*0.06)];
     
     //center label
     //[label setCenter:header.center]
     
     [header addSubview:label]; */
    
    
    self.locationLabel = [[UILabel alloc] initWithFrame:CGRectMake(0, screenHeight*0.10, screenWidth, screenHeight*0.05)];
    self.locationLabel.text = @"Location";
    [self.locationLabel sizeToFit];
    [self.locationLabel setCenter:CGPointMake(screenWidth/2, screenHeight*0.10)];
    [self.view addSubview:locationLabel];
    
    
    //  [mySelect setElements:[NSArray arrayWithObjects:@"Line 1",@"Line 2",@"Line 3",@"Line 4", nil]];
    
    /*UILabel *selectLabelOne = [[UILabel alloc] initWithFrame:CGRectMake(10, 0, screenWidth*0.3, screenHeight*0.05)];
     //[selectLabel sizeToFit];
     selectLabelOne.text = @"Select";
     selectLabelOne.textColor = [Utils colorWithHexString:@"ab3830"];*/
    
    
    /*UILabel *selectLabelTwo = [[UILabel alloc] initWithFrame:CGRectMake(10, 0, screenWidth*0.3, screenHeight*0.05)];
     //[selectLabel sizeToFit];
     selectLabelTwo.text = @"Select";
     selectLabelTwo.textColor = [Utils colorWithHexString:@"ab3830"];*/
    
    
    UIView *locationBar =[[UIView alloc] initWithFrame:CGRectMake( 0 , screenHeight*0.15, screenWidth, screenHeight*0.05)];
    [locationBar setBackgroundColor:[Utils colorWithHexString:@"d2d3d4"]];
    
    //[locationBar addSubview:selectLabelOne];
    
    UITextView *textViewOne = [[UITextView alloc] initWithFrame:CGRectMake(0, 0, screenWidth*0.5, screenHeight*0.05)];
    [textViewOne setCenter:CGPointMake(screenWidth/2, screenHeight*0.05/2)];
    [textViewOne setTextAlignment:NSTextAlignmentCenter];
    [textViewOne setTextColor:[Utils colorWithHexString:@"447fc2" ]];
    [textViewOne setText :@"Select"];
    textViewOne.font = [UIFont boldSystemFontOfSize:16.0];
    //[textViewOne.layer setBorderWidth:1];
    
    //RK:    [locationBar addSubview:textViewOne];
    
    UIView *cropTypeBar =[[UIView alloc] initWithFrame:CGRectMake( 0 , screenHeight*0.30, screenWidth, screenHeight*0.05)];
    [cropTypeBar setBackgroundColor:[Utils colorWithHexString:@"d2d3d4"]];
    
    //---------------------------------------
    //RK: Action sheet to present picker view
    //    actionSheet = [[UIActionSheet alloc] initWithTitle:@"Select a Location"
    //                                                             delegate:self
    //                                                    cancelButtonTitle:@"Cancel"
    //                                               destructiveButtonTitle:@"Test 1"
    //                                                    otherButtonTitles:@"Test 2",nil];
    //
    //    actionSheet.actionSheetStyle = UIActionSheetStyleBlackOpaque;
    //    [self createLocationPicker];
    self.locationBtn = [UIButton buttonWithType:UIButtonTypeSystem];
    [self.locationBtn setFrame:CGRectMake(0, 0, screenWidth*0.5, screenHeight*0.05)];
    [self.locationBtn setTitle:@"Select" forState:UIControlStateNormal];
    [self.locationBtn setBackgroundColor:[UIColor whiteColor]];
    self.locationBtn.center = CGPointMake(screenWidth/2, screenHeight*0.05/2);
    
    [self.locationBtn addTarget:self action:@selector(buttonPressed:)
               forControlEvents:UIControlEventTouchUpInside];
    
    self.addLocationBtn = [UIButton buttonWithType:UIButtonTypeContactAdd];
    [self.addLocationBtn setFrame:CGRectMake(0, 0, 20, 20)];
    [self.addLocationBtn setCenter:CGPointMake(screenWidth/2 + self.locationBtn.frame.size.width/2 + 20, screenHeight*0.05/2)] ;
    [self.addLocationBtn addTarget:self action:@selector(showAddLocation:) forControlEvents:UIControlEventTouchUpInside];
    
    [locationBar addSubview:self.locationBtn];
    [locationBar addSubview:self.addLocationBtn];
    
    //---------------------------------------
    
    // [viewbar addSubview:selectLabelTwo];
    
    self.cropTypeLabel = [[UILabel alloc] initWithFrame:CGRectMake(0, screenHeight*0.20, screenWidth, screenHeight*0.05)];
    self.cropTypeLabel.text = @"Crop Type";
    [self.cropTypeLabel sizeToFit];
    [self.cropTypeLabel setCenter:CGPointMake(screenWidth/2, screenHeight*0.25)];
    [self.view addSubview:cropTypeLabel];
    
    self.cropTypeBtn = [UIButton buttonWithType:UIButtonTypeSystem];
    
    [self.cropTypeBtn setTitle:@"Select" forState:UIControlStateNormal];
    [self.cropTypeBtn setFrame:CGRectMake(0, 0, screenWidth*0.5, screenHeight*0.05)];
    [self.cropTypeBtn setCenter:CGPointMake(screenWidth/2, screenHeight*0.05/2)];
    [self.cropTypeBtn addTarget:self action:@selector(buttonPressed:)
               forControlEvents:UIControlEventTouchUpInside];
    [self.cropTypeBtn setBackgroundColor:[UIColor whiteColor]];
    
    [cropTypeBar addSubview:self.cropTypeBtn];
    
    /*RK:
     UITextView *textViewTwo = [[UITextView alloc] initWithFrame:CGRectMake(0, 0, screenWidth*0.5, screenHeight*0.05)];
     [textViewTwo setCenter:CGPointMake(screenWidth/2, screenHeight*0.05/2)];
     [textViewTwo setTextAlignment:NSTextAlignmentCenter];
     [textViewTwo setTextColor:[Utils colorWithHexString:@"447fc2" ]];
     [textViewTwo setText :@"Select"];
     textViewTwo.font = [UIFont boldSystemFontOfSize:16.0];
     
     [cropTypeBar addSubview:textViewTwo];
     */
    
    UIView *gStageBar =[[UIView alloc] initWithFrame:CGRectMake( 0 , screenHeight*0.50, screenWidth, screenHeight*0.05)];
    [gStageBar setBackgroundColor:[Utils colorWithHexString:@"d2d3d4"]];
    
    
    self.growthStageLabel = [[UILabel alloc] initWithFrame:CGRectMake(0, screenHeight*0.40, screenWidth, screenHeight*0.05)];
    self.growthStageLabel.text = @"Growth Stage (1,2,3,4)";
    [self.growthStageLabel sizeToFit];
    [self.growthStageLabel setCenter:CGPointMake(screenWidth/2, screenHeight*0.45)];
    [self.view addSubview:self.growthStageLabel];
    
    self.growthStageBtn = [UIButton buttonWithType:UIButtonTypeSystem];
    [self.growthStageBtn setFrame:CGRectMake(0, 0, screenWidth*0.20, screenHeight*0.05)];
    [self.growthStageBtn setTitle:@"Select" forState:UIControlStateNormal];
    [self.growthStageBtn setCenter:CGPointMake(screenWidth/2, screenHeight*0.05/2)];
    [self.growthStageBtn addTarget:self action:@selector(buttonPressed:)
                  forControlEvents:UIControlEventTouchUpInside];
    [self.growthStageBtn setBackgroundColor:[UIColor whiteColor]];
    [gStageBar addSubview:self.growthStageBtn];
    
    
    //    [self.view addSubview:header];
    [self.view addSubview:locationBar];
    [self.view addSubview:cropTypeBar];
    [self.view addSubview:gStageBar];
    
    
    UIImageView *imageView = [[UIImageView alloc] initWithImage:[UIImage imageNamed:@"swipearrow.png"]];
    //standard height of tab bar is 50
    imageView.frame = CGRectMake((screenWidth-322/2),(screenHeight-163/2)-50,322/2,163/2);
    
    /*RK
     UITextView *textViewGrowthStage = [[UITextView alloc] initWithFrame:CGRectMake(0, 0, screenWidth*0.20, screenHeight*0.05)];
     [textViewGrowthStage setCenter:CGPointMake(screenWidth/2, screenHeight*0.05/2)];
     [textViewGrowthStage setTextAlignment:NSTextAlignmentCenter];
     textViewGrowthStage.font = [UIFont boldSystemFontOfSize:16.0];
     
     [gStageBar addSubview:textViewGrowthStage];
     */
    
    UISwipeGestureRecognizer *mSwipeUpRecognizerLeft = [[UISwipeGestureRecognizer alloc] initWithTarget:self action:@selector(switchWindowLeft)];
    [mSwipeUpRecognizerLeft setDirection:(UISwipeGestureRecognizerDirectionLeft)];
    [[self view] addGestureRecognizer:mSwipeUpRecognizerLeft];
    
    UISwipeGestureRecognizer *mSwipeUpRecognizerRight = [[UISwipeGestureRecognizer alloc] initWithTarget:self action:@selector(switchWindowRight)];
    [mSwipeUpRecognizerRight setDirection:(UISwipeGestureRecognizerDirectionRight)];
    [[self view] addGestureRecognizer:mSwipeUpRecognizerRight];
    
    
    
    //[self.view addSubview:imageView];
    
    //iphone, dismiss keyboard when touching outside of textfield
    UITapGestureRecognizer *tap = [[UITapGestureRecognizer alloc]
                                   initWithTarget:self
                                   action:@selector(dismissKeyboard)];
    
    [self.view addGestureRecognizer:tap];
    
    self.menuVC = [[MenuViewController alloc] init];
    self.navigationItem.rightBarButtonItem = [[UIBarButtonItem alloc] initWithImage:[UIImage imageNamed:@"menuIcon.png"] style:UIBarButtonItemStylePlain target:self action:@selector(showMenu)];
    [self.navigationItem.rightBarButtonItem setTintColor:[UIColor whiteColor]];

    self.navController = [[UINavigationController alloc] initWithRootViewController:menuVC];
    [menuVC.view setBackgroundColor:[UIColor whiteColor]];
    
    
}

-(void)showMenu
{
    [self presentViewController:self.navController animated:YES completion:nil];
}

-(void)dismissKeyboard {
    [self.view endEditing:YES];
}

-(void) switchWindowLeft{
    NSLog(@"switch window left");
//    SecondViewController *secondViewController = [[SecondViewController alloc] init];
//    [self.navigationController pushViewController:secondViewController animated:false];
    
    enterDataVC.cropType = self.cropType;
    enterDataVC.growthStage = self.growthStage;
    [self.navigationController pushViewController:enterDataVC animated:YES];
}

-(void) switchWindowRight{
    NSLog(@"switch window right");
}

- (void) tapDetectedSettings{
    NSLog(@"tap detected on settings");
    //  SettingsViewController *settings = [[SettingsViewController alloc] initWithNibName:nil bundle:nil];
    // [self.navigationController pushViewController:settings animated:false];
}

//RK
- (void)buttonPressed:(UIButton *)button
{
    if (button == doneBtn1 || button == doneBtn2 || button == doneBtn3)
    {
        [self.view layoutIfNeeded];
        self.locationContainerVerticalConstraint.constant = 200;
        self.cropTypeContainerVerticalConstraint.constant = 200;
        self.growthStageContainerVerticalConstraint.constant = 200;
        [UIView animateWithDuration:0.5 delay:0 options:UIViewAnimationOptionCurveEaseOut animations:^{
            [self.view layoutIfNeeded];
        } completion:nil];
    }
    
    if (button == locationBtn)
    {
        [self.view layoutIfNeeded];
        self.locationContainerVerticalConstraint.constant = self.locationContainerVerticalConstraint.constant == 0 ? 200 : 0;
        [UIView animateWithDuration:0.5 delay:0 options:UIViewAnimationOptionCurveEaseOut animations:^{
            [self.view layoutIfNeeded];
        } completion:nil];
        self.location = [self.locationsArray objectAtIndex:[self.locationPicker selectedRowInComponent:0]];
        [self.locationBtn setTitle:self.location forState:UIControlStateNormal];
    }
    
    if (button == growthStageBtn)
    {
        [self.view layoutIfNeeded];
        self.growthStageContainerVerticalConstraint.constant = self.growthStageContainerVerticalConstraint.constant == 0 ? 200 : 0;
        [UIView animateWithDuration:0.5 delay:0 options:UIViewAnimationOptionCurveEaseOut animations:^{
            [self.view layoutIfNeeded];
        } completion:nil];
        self.growthStage = [self.growthStageArray objectAtIndex:[self.growthStagePicker selectedRowInComponent:0]];
        [self.growthStageBtn setTitle:self.growthStage forState:UIControlStateNormal];

    }
    
    if (button == cropTypeBtn)
    {
        [self.view layoutIfNeeded];
        self.cropTypeContainerVerticalConstraint.constant = self.cropTypeContainerVerticalConstraint.constant == 0 ? 200 : 0;
        [UIView animateWithDuration:0.5 delay:0 options:UIViewAnimationOptionCurveEaseOut animations:^{
            [self.view layoutIfNeeded];
        } completion:nil];
        self.cropType = [self.cropTypeArray objectAtIndex:[self.cropTypePicker selectedRowInComponent:0]];
        [self.cropTypeBtn setTitle:self.cropType forState:UIControlStateNormal];

    }
    
}


//
//-(void)createLocationPicker
//{
//    locationPickerView = [[UIPickerView alloc] init];
//    locationPickerView.delegate = self;
//    locationPickerView.dataSource = self;
//
//    CGRect pickerRect = locationPickerView.bounds;
//    pickerRect.origin.y = 35;
//    locationPickerView.frame = pickerRect;
//}

//RK-------custom action sheet view
- (void)setUpContainerView
{
    //Location Picker
    self.locationContainerView = [[UIView alloc]initWithFrame:CGRectMake(0, self.view.frame.size.height + 200, self.view.frame.size.width, 200)];
    self.locationContainerView.backgroundColor = [UIColor whiteColor];
    [self.view addSubview:self.locationContainerView];
    [self.locationContainerView setTranslatesAutoresizingMaskIntoConstraints:NO];
    
    NSArray *hConstraint = [NSLayoutConstraint constraintsWithVisualFormat:@"|[containerView]|"
                                                                   options:0
                                                                   metrics:@{}
                                                                     views:@{@"containerView": self.locationContainerView}];
    NSArray *vConstraint = [NSLayoutConstraint constraintsWithVisualFormat:@"V:[containerView(==200)]"
                                                                   options:0
                                                                   metrics:@{}
                                                                     views:@{@"containerView": self.locationContainerView}];
    self.locationContainerVerticalConstraint = [NSLayoutConstraint constraintWithItem:self.locationContainerView
                                                                    attribute:NSLayoutAttributeBottom
                                                                    relatedBy:NSLayoutRelationEqual
                                                                       toItem:self.view
                                                                    attribute:NSLayoutAttributeBottom
                                                                   multiplier:1 constant:200];
    [self.view addConstraints:hConstraint];
    [self.view addConstraints:vConstraint];
    [self.view addConstraints:@[self.locationContainerVerticalConstraint]];
    
    //Crop-Type Picker
    self.cropTypeContainerView = [[UIView alloc]initWithFrame:CGRectMake(0, self.view.frame.size.height + 200, self.view.frame.size.width, 200)];
    self.cropTypeContainerView.backgroundColor = [UIColor whiteColor];
    [self.view addSubview:self.cropTypeContainerView];
    [self.cropTypeContainerView setTranslatesAutoresizingMaskIntoConstraints:NO];
    
    NSArray *hConstraint2 = [NSLayoutConstraint constraintsWithVisualFormat:@"|[containerView]|"
                                                                   options:0
                                                                   metrics:@{}
                                                                     views:@{@"containerView": self.cropTypeContainerView}];
    NSArray *vConstraint2 = [NSLayoutConstraint constraintsWithVisualFormat:@"V:[containerView(==200)]"
                                                                   options:0
                                                                   metrics:@{}
                                                                     views:@{@"containerView": self.cropTypeContainerView}];
    
    self.cropTypeContainerVerticalConstraint = [NSLayoutConstraint constraintWithItem:self.cropTypeContainerView
                                                                    attribute:NSLayoutAttributeBottom
                                                                    relatedBy:NSLayoutRelationEqual
                                                                       toItem:self.view
                                                                    attribute:NSLayoutAttributeBottom
                                                                   multiplier:1 constant:200];
    [self.view addConstraints:hConstraint2];
    [self.view addConstraints:vConstraint2];
    [self.view addConstraints:@[self.cropTypeContainerVerticalConstraint]];
    
    //Growth-Stage Picker
    self.growthStageContainerView = [[UIView alloc]initWithFrame:CGRectMake(0, self.view.frame.size.height + 200, self.view.frame.size.width, 200)];
    self.growthStageContainerView.backgroundColor = [UIColor whiteColor];
    [self.view addSubview:self.growthStageContainerView];
    [self.growthStageContainerView setTranslatesAutoresizingMaskIntoConstraints:NO];
    
    NSArray *hConstraint3 = [NSLayoutConstraint constraintsWithVisualFormat:@"|[containerView]|"
                                                                    options:0
                                                                    metrics:@{}
                                                                      views:@{@"containerView": self.growthStageContainerView}];
    NSArray *vConstraint3 = [NSLayoutConstraint constraintsWithVisualFormat:@"V:[containerView(==200)]"
                                                                    options:0
                                                                    metrics:@{}
                                                                      views:@{@"containerView": self.growthStageContainerView}];
    
    self.growthStageContainerVerticalConstraint = [NSLayoutConstraint constraintWithItem:self.growthStageContainerView
                                                                            attribute:NSLayoutAttributeBottom
                                                                            relatedBy:NSLayoutRelationEqual
                                                                               toItem:self.view
                                                                            attribute:NSLayoutAttributeBottom
                                                                           multiplier:1 constant:200];
    [self.view addConstraints:hConstraint3];
    [self.view addConstraints:vConstraint3];
    [self.view addConstraints:@[self.growthStageContainerVerticalConstraint]];
    
}

- (void)setUpPickers
{
    self.locationPicker = [[UIPickerView alloc]initWithFrame:CGRectMake(0, 0, self.view.frame.size.width, 200)];
    self.locationPicker.autoresizingMask = UIViewAutoresizingFlexibleWidth | UIViewAutoresizingFlexibleBottomMargin;
    self.locationPicker.delegate = self;
    self.locationPicker.dataSource = self;
    [self.locationContainerView addSubview:self.locationPicker];
    
    self.cropTypePicker = [[UIPickerView alloc]initWithFrame:CGRectMake(0, 0, self.view.frame.size.width, 200)];
    self.cropTypePicker.autoresizingMask = UIViewAutoresizingFlexibleWidth | UIViewAutoresizingFlexibleBottomMargin;
    self.cropTypePicker.delegate = self;
    self.cropTypePicker.dataSource = self;
    [self.cropTypeContainerView addSubview:self.cropTypePicker];
    
    self.growthStagePicker = [[UIPickerView alloc]initWithFrame:CGRectMake(0, 0, self.view.frame.size.width, 200)];
    self.growthStagePicker.autoresizingMask = UIViewAutoresizingFlexibleWidth | UIViewAutoresizingFlexibleBottomMargin;
    self.growthStagePicker.delegate = self;
    self.growthStagePicker.dataSource = self;
    [self.growthStageContainerView addSubview:self.growthStagePicker];
    
}

- (void)setUpToolbar
{
    UIToolbar *toolbar = [[UIToolbar alloc]initWithFrame:CGRectMake(0, 0, self.view.frame.size.width, 40)];
    toolbar.autoresizingMask = UIViewAutoresizingFlexibleWidth;
    toolbar.barTintColor = [Utils colorWithHexString:@"149c46"];
    [self.locationContainerView addSubview:toolbar];
    
    doneBtn1 = [[UIButton alloc]initWithFrame:CGRectMake(self.view.frame.size.width-60, 5, 50, 40)];
    [doneBtn1 setTitle:@"Done" forState:UIControlStateNormal];
    [doneBtn1 addTarget:self action:@selector(buttonPressed:) forControlEvents:UIControlEventTouchUpInside];
    doneBtn1.autoresizingMask = UIViewAutoresizingFlexibleLeftMargin;
    [toolbar addSubview:doneBtn1];
    
    UIToolbar *toolbar2 = [[UIToolbar alloc]initWithFrame:CGRectMake(0, 0, self.view.frame.size.width, 40)];
    toolbar2.autoresizingMask = UIViewAutoresizingFlexibleWidth;
    toolbar2.barTintColor = [Utils colorWithHexString:@"149c46"];
    [self.cropTypeContainerView addSubview:toolbar2];
    doneBtn2 = [[UIButton alloc]initWithFrame:CGRectMake(self.view.frame.size.width-60, 5, 50, 40)];
    [doneBtn2 setTitle:@"Done" forState:UIControlStateNormal];
    [doneBtn2 addTarget:self action:@selector(buttonPressed:) forControlEvents:UIControlEventTouchUpInside];
    doneBtn2.autoresizingMask = UIViewAutoresizingFlexibleLeftMargin;
    [toolbar2 addSubview:doneBtn2];
    
    UIToolbar *toolbar3 = [[UIToolbar alloc]initWithFrame:CGRectMake(0, 0, self.view.frame.size.width, 40)];
    toolbar3.autoresizingMask = UIViewAutoresizingFlexibleWidth;
    toolbar3.barTintColor = [Utils colorWithHexString:@"149c46"];
    [self.growthStageContainerView addSubview:toolbar3];
    doneBtn3 = [[UIButton alloc]initWithFrame:CGRectMake(self.view.frame.size.width-60, 5, 50, 40)];
    [doneBtn3 setTitle:@"Done" forState:UIControlStateNormal];
    [doneBtn3 addTarget:self action:@selector(buttonPressed:) forControlEvents:UIControlEventTouchUpInside];
    doneBtn3.autoresizingMask = UIViewAutoresizingFlexibleLeftMargin;
    [toolbar3 addSubview:doneBtn3];
}
//-------------------------------

-(void)showAddLocation:(id)sender
{
    UIAlertView *addLocationAlertView = [[UIAlertView alloc] initWithTitle:@"Add Location" message:@"Please enter a name for the new location:" delegate:self cancelButtonTitle:@"Cancel" otherButtonTitles:@"Add", nil] ;
    addLocationAlertView.tag = 1;
    addLocationAlertView.alertViewStyle = UIAlertViewStylePlainTextInput;
    [addLocationAlertView show];
}


//RK----------------------------------------------------
#pragma mark - UIPicker

- (NSInteger)numberOfComponentsInPickerView:(UIPickerView *)pickerView {
    return 1;
}

- (NSInteger)pickerView:(UIPickerView *)pickerView numberOfRowsInComponent:(NSInteger)component
{
    if (pickerView == self.locationPicker)
    {
        return [self.locationsArray count];
    }
    
    if (pickerView == self.cropTypePicker)
    {
        return [self.cropTypeArray count];
    }
    
    if (pickerView == self.growthStagePicker)
    {
        return [self.growthStageArray count];
    }
    
    return 0;

}

- (NSString *)pickerView:(UIPickerView *)pickerView titleForRow:(NSInteger)row forComponent:(NSInteger)component
{
    if (pickerView == self.locationPicker)
    {
        return [self.locationsArray objectAtIndex:row];
    }
    
    if (pickerView == self.cropTypePicker)
    {
        return [self.cropTypeArray objectAtIndex:row];
    }
    
    if (pickerView == self.growthStagePicker)
    {
        return [self.growthStageArray objectAtIndex:row];
    }
    
    return @"";
}

- (void)pickerView:(UIPickerView *)pickerView didSelectRow:(NSInteger)row inComponent:(NSInteger)component
{
    if (pickerView == self.locationPicker)
    {
        self.location = [self.locationsArray objectAtIndex:row];
        [self.locationBtn setTitle:self.location forState:UIControlStateNormal];
        NSLog(@"selected: %@", self.location);
    }
    
    if (pickerView == self.cropTypePicker)
    {
        self.cropType = [self.cropTypeArray objectAtIndex:row];
        [self.cropTypeBtn setTitle:self.cropType forState:UIControlStateNormal];
        NSLog(@"selected: %@", self.cropType);
    }
    
    if (pickerView == self.growthStagePicker)
    {
        self.growthStage = [self.growthStageArray objectAtIndex:row];
        [self.growthStageBtn setTitle:self.growthStage forState:UIControlStateNormal];
        NSLog(@"selected: %@", self.growthStage);
    }
    
}

- (void)alertView:(UIAlertView *)alertView clickedButtonAtIndex:(NSInteger)buttonIndex
{
    NSString *fileName;
    
    if( buttonIndex == 1)
    {
        //get location name from user
        UITextField * alertTextField = [alertView textFieldAtIndex:0];
        NSLog(@"location name: %@",alertTextField.text);
        
        //get the documents directory:
//        NSArray *paths = NSSearchPathForDirectoriesInDomains
//        (NSDocumentDirectory, NSUserDomainMask, YES);
//        NSString *documentsDirectory = [paths objectAtIndex:0];
//        
//        //make a file name to write the data to using the documents directory:
//        fileName = [NSString stringWithFormat:@"%@/%@.json",
//                    documentsDirectory,alertTextField.text];
//        
//        //write content
//        NSMutableDictionary *fileDict = [[NSMutableDictionary alloc]init];
//        [fileDict setValue:productLabels forKey:@"productNames"];
//        [fileDict setValue:results forKey:@"results"];
//        
//        NSData *jsonData = [NSJSONSerialization dataWithJSONObject:fileDict options:0 error:nil];
//        
//        // Checking the data
//        NSLog(@"json data: %@",[[NSString alloc] initWithData:jsonData encoding:NSUTF8StringEncoding]);
//        
//        [jsonData writeToFile:fileName atomically:YES];
        
        [self.locationsArray addObject:alertTextField.text];
        [self.locationPicker reloadAllComponents];
    }
    
}

//--------------------------------------------------------------------

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

@end
