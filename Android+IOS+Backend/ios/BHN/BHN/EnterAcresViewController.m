//
//  EnterAcresViewController.m
//  BHN
//
//  Created by Rohit Kharat on 10/12/14.
//  Copyright (c) 2014 BHN. All rights reserved.
//

#import "EnterAcresViewController.h"
#import "EnterDataViewController.h"
#import "Utils.h"
#import "ResultsViewController.h"
#import "AppDelegate.h"

@interface EnterAcresViewController ()

@end

@implementation EnterAcresViewController

@synthesize cropType, growthStage, labData1, labData2, acres, labData, results, BHNData, menuVC, navController;

- (id)initWithNibName:(NSString *)nibNameOrNil bundle:(NSBundle *)nibBundleOrNil
{
    self = [super initWithNibName:nibNameOrNil bundle:nibBundleOrNil];
    if (self) {
        // Custom initialization
        dataCreated = FALSE;
    }
    return self;
}

- (void)viewDidLoad
{
    [super viewDidLoad];
    // Do any additional setup after loading the view.
    resultsVC = [[ResultsViewController alloc] init];

    
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
    
    UIImage *backButtonImage = [UIImage imageNamed:@"misc_BACK ARROW.png"];
    UIBarButtonItem *barButtonItem = [[UIBarButtonItem alloc]init];
    barButtonItem.image = backButtonImage;
    self.navigationItem.backBarButtonItem.image = backButtonImage;
    // barButtonItem.image = backButtonImage;
    
    UIBarButtonItem *backButton = [[UIBarButtonItem alloc]
                                   initWithImage:backButtonImage
                                   style:UIBarButtonItemStylePlain
                                   target:self
                                   action:@selector(back)];
    
    self.navigationItem.backBarButtonItem = backButton;
    
    [self.navigationItem setLeftBarButtonItem:backButton animated:YES];
    self.navigationItem.backBarButtonItem.tintColor = [UIColor whiteColor];
    
    //iphone, dismiss keyboard when touching outside of textfield
    UITapGestureRecognizer *tap = [[UITapGestureRecognizer alloc]
                                   initWithTarget:self
                                   action:@selector(dismissKeyboard)];
    
    [self.view addGestureRecognizer:tap];
    
    [self.view setBackgroundColor:[Utils colorWithHexString:@"e8e8e8"]];
    
    EnterAcresLabel = [[UILabel alloc]initWithFrame:CGRectMake(0, 0, screenWidth, 45)];
    [EnterAcresLabel setCenter:CGPointMake(screenWidth/2, screenHeight*0.2)];
    [EnterAcresLabel setTextAlignment:NSTextAlignmentCenter];
    [EnterAcresLabel setTextColor:[Utils colorWithHexString:@"447fc2"]];
    EnterAcresLabel.text = @"Enter Total Number of Acres to Treat";
    [self.view addSubview:EnterAcresLabel];
    
    acresTextField = [[UITextField alloc]initWithFrame:CGRectMake(0, 0, screenWidth*0.4, 45)];
    [acresTextField setBackgroundColor:[UIColor whiteColor]];
    [acresTextField setBorderStyle:UITextBorderStyleNone];
    [acresTextField setTextColor:[Utils colorWithHexString:@"447fc2"]];
    [acresTextField setTextAlignment:NSTextAlignmentCenter];
    [acresTextField setCenter:CGPointMake(screenWidth/2, screenHeight*0.3)];
    [acresTextField setKeyboardType:UIKeyboardTypeDecimalPad];
    [acresTextField setDelegate:self];
    [self.view addSubview:acresTextField];
    
    getResultsButton = [[UIButton alloc]initWithFrame:CGRectMake(0, 0, screenWidth*0.4, 45)];
    UIImage *blueButtonImage = [[UIImage imageNamed:@"blueGetResultsButton.png"]
                                resizableImageWithCapInsets:UIEdgeInsetsMake(18, 18, 18, 18)];
    [getResultsButton setBackgroundImage:blueButtonImage forState:UIControlStateNormal];
    [getResultsButton setCenter:CGPointMake(screenWidth/2, screenHeight*0.4)];
    [getResultsButton setTitle:@"GET RESULTS" forState:UIControlStateNormal];
    [getResultsButton addTarget:self action:@selector(getResults) forControlEvents:UIControlEventTouchUpInside];
    [self.view addSubview:getResultsButton];
    
    labData = [[NSMutableArray alloc] init];
    results = [[NSMutableArray alloc] init];
    
    for(NSString *value in self.labData1)
    {
        //        NSLog(@"value %@", value);
        [labData addObject:value];
    }
    
    for(NSString *value in self.labData2)
    {
        //        NSLog(@"value %@", value);
        [labData addObject:value];
    }
    
    //    for(NSString *value in self.labData)
    //    {
    //        NSLog(@"value %@", value);
    //    }
    
    if (!dataCreated) {
        [self createData];
    }

    self.menuVC = [[MenuViewController alloc] init];
    self.navigationItem.rightBarButtonItem = [[UIBarButtonItem alloc] initWithImage:[UIImage imageNamed:@"menuIcon.png"] style:UIBarButtonItemStylePlain target:self action:@selector(showMenu)];
    [self.navigationItem.rightBarButtonItem setTintColor:[UIColor whiteColor]];
    
    self.navController = [[UINavigationController alloc] initWithRootViewController:self.menuVC];
    [self.menuVC.view setBackgroundColor:[UIColor whiteColor]];
    
    
}

-(void)showMenu
{
    [self presentViewController:self.navController animated:YES completion:nil];
}
-(void)dismissKeyboard {
    [self.view endEditing:YES];
}

-(void)back
{
    [self.navigationController popViewControllerAnimated:YES];
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

- (BOOL)textFieldShouldReturn:(UITextField *)textField
{
    [textField resignFirstResponder];
    return YES;
}

-(void)getResults
{
    
    NSString *cropAndGrowthStage = [self.cropType stringByAppendingString:self.growthStage];
    //    NSLog(@"%@", cropAndGrowthStage);
    
    cropDetails = [BHNData objectForKey:cropAndGrowthStage];
    
    //    NSArray *Almonds1 = [[NSArray alloc] initWithObjects:@3.2, @0.32, @2.56, @2.56, @0.32, @0.32, @130, @37, @60, @16, @42, nil];
    nutritionalDeficiency = [[NSMutableArray alloc] init];
    
    //Subtract Foliar Analysis Data(FAD) from Recommended Tissue Level
    for (int i=0; i<[self.labData count]; i++)
    {
        NSNumber * temp = [NSNumber numberWithFloat:[[cropDetails objectAtIndex:i] floatValue] - [[self.labData objectAtIndex:i] floatValue]];
        //        NSLog(@"subtraction value = %f", [temp floatValue]);
        
        //if subtraction is negative, store it as zero
        temp = ([temp floatValue] < 0.0f) ? @0 : temp;
        [nutritionalDeficiency addObject: temp];
    }
    
    //    for (NSNumber *no in nutritionalDeficiency)
    //    {
    //        NSLog(@"deficiency = %@", no);
    //    }
    
    //deficiency factor for the selected crop
    NSString *cropAndFactor = [self.cropType stringByAppendingString:@"Factor"];
    
    
//    cropFactor = [[NSArray alloc] initWithObjects:@0.1,	@0.008,	@0.075,	@0.025,	@0.025,	@0.01,	@2.5, @2.5,	@2.5, @1, @2.5, nil];
    cropFactor = [BHNData objectForKey:cropAndFactor];
    
    foliarApplicationRate = [[NSMutableArray alloc] init];
    
    //divide nutritional deficiency by deficiency factor
    for (int i=0; i<[nutritionalDeficiency count]; i++)
    {
        NSNumber *division = [NSNumber numberWithFloat:([[nutritionalDeficiency objectAtIndex:i] floatValue])/ ([[cropFactor objectAtIndex:i] floatValue])];
        
        //if subtraction is < 2, store it as zero
        division = ([division floatValue] < 2.0f) ? @0 : division;
        [foliarApplicationRate addObject: division];
    }
    
    //    for (NSNumber *no in foliarApplicationRate)
    //            {
    //                NSLog(@"foliarApplicationRate = %@", no);
    //            }
    
    int perGallon = 128;
    self.acres = [acresTextField text];
    
    self.results = [[NSMutableArray alloc] init];
    
    NSNumber *numerator;
    float acresFloat = [[NSNumber numberWithFloat:[self.acres floatValue]] floatValue];
    
    for (int i=0; i<[foliarApplicationRate count]; i++)
    {
        numerator = [NSNumber numberWithFloat:[[foliarApplicationRate objectAtIndex:i] floatValue]];
        
        numerator = @([numerator floatValue] * acresFloat);
        float result = [numerator floatValue]/perGallon ;
        [self.results addObject:[NSNumber numberWithFloat:result]];
    }
    
    resultsVC.results = self.results;
    [self.navigationController pushViewController:resultsVC animated:YES];
}

-(void)createData
{
    dataCreated = TRUE;
    
    NSLog(@"creating data");
    
    //Almonds Data
    NSArray *Almonds1 = [[NSArray alloc] initWithObjects:@3.2, @0.32, @2.56, @2.56, @0.32, @0.32, @130, @37, @60, @16, @42, nil];
    NSArray *Almonds2 = [[NSArray alloc] initWithObjects:@3.8, @0.38, @3.04, @3.04, @0.38, @0.38, @130, @37, @60, @16, @42, nil];
    NSArray *Almonds3 = [[NSArray alloc] initWithObjects:@3.4, @0.34, @3.04, @3.04, @0.34, @0.34, @130, @37, @60, @16, @42, nil];
    NSArray *Almonds4 = [[NSArray alloc] initWithObjects:@3, @0.3, @3, @3, @0.3, @0.3, @130, @37, @60, @16, @42, nil];
    
    NSArray *AlmondsFactor = [[NSArray alloc] initWithObjects:@0.1, @0.008, @0.075, @0.025,	@0.025,	@0.01, @2.5, @2.5, @2.5, @1, @2.5, nil];
    
    //Apples   Data
    NSArray *Apples1 = [[NSArray alloc] initWithObjects:@2.1 ,@0.21 ,@1.68 ,@1.68 ,@0.21 ,@0.21, @105 ,@25 ,@65 ,@12 ,@31, nil];
    NSArray *Apples2 = [[NSArray alloc] initWithObjects:@2.5,@0.25 ,@2 ,@2 ,@0.25 ,@0.25, @105 ,@25 ,@65 ,@12 ,@31, nil];
    NSArray *Apples3 = [[NSArray alloc] initWithObjects:@2.2 ,@0.22 ,@2.2 ,@2.2 ,@0.22 ,@0.22, @105 ,@25 ,@65 ,@12 ,@31, nil];
    NSArray *Apples4 = [[NSArray alloc] initWithObjects:@2 ,@0.2 ,@1.6 ,@1.6 ,@0.2 ,@0.2, @105 ,@25 ,@65 ,@12 ,@31, nil];
    
    NSArray *ApplesFactor = [[NSArray alloc] initWithObjects:@0.1 ,@0.008 ,@0.075 ,@0.025 ,@0.025 ,@0.01  ,@2.5 ,@2.5 ,@2.5 ,@1 ,@2.5, nil];
    
    //Cantaloupe   Data
    NSArray *Cantaloupe1 = [[NSArray alloc] initWithObjects:@3.8 ,@0.38 ,@3.04 ,@3.04 ,@0.38 ,@0.38, @118 ,@53 ,@91 ,@14 ,@62, nil];
    NSArray *Cantaloupe2 = [[NSArray alloc] initWithObjects:@4.2 ,@0.42 ,@3.36 ,@3.36 ,@0.42 ,@0.42, @118 ,@53 ,@91 ,@14 ,@62, nil];
    NSArray *Cantaloupe3 = [[NSArray alloc] initWithObjects:@4 ,@0.4 ,@4 ,@4 ,@0.4 ,@0.4, @118 ,@53 ,@91 ,@14 ,@62, nil];
    NSArray *Cantaloupe4 = [[NSArray alloc] initWithObjects:@3.8 ,@0.38 ,@4.2 ,@4.2 ,@0.38 ,@0.38, @118 ,@53 ,@91 ,@14 ,@62, nil];
    
    NSArray *CantaloupeFactor = [[NSArray alloc] initWithObjects:@0.2 ,@0.015 ,@0.15 ,@0.05 ,@0.05 ,@0.02  ,@5 ,@5 ,@5 ,@2 ,@5, nil];
    
    //Chilipeppers   Data
    NSArray *Chilipeppers1 = [[NSArray alloc] initWithObjects:@4.4 ,@0.44 ,@3.52 ,@3.52 ,@0.44 ,@0.44, @245 ,@43 ,@115 ,@17 ,@46, nil];
    NSArray *Chilipeppers2 = [[NSArray alloc] initWithObjects:@4.6 ,@0.44 ,@3.52 ,@3.52 ,@0.44 ,@0.44, @245 ,@43 ,@115 ,@17 ,@46, nil];
    NSArray *Chilipeppers3 = [[NSArray alloc] initWithObjects:@3 ,@4.6 ,@0.44 ,@3.52 ,@3.52 ,@0.44 ,@0.44, @245 ,@43 ,@115 ,@17 ,@46, nil];
    NSArray *Chilipeppers4 = [[NSArray alloc] initWithObjects:@4 ,@3.8 ,@0.38 ,@3.52 ,@3.52 ,@0.38 ,@0.38, @245 ,@43 ,@115 ,@17 ,@46, nil];
    
    NSArray *ChilipeppersFactor = [[NSArray alloc] initWithObjects:@0.2 ,@0.015 ,@0.15 ,@0.05 ,@0.05 ,@0.02  ,@5 ,@5 ,@5 ,@2 ,@5, nil];
    
    //Corn   Data
    NSArray *Corn1 = [[NSArray alloc] initWithObjects:@3.2 ,@0.32 ,@2.56 ,@2.56 ,@0.32 ,@0.32, @95 ,@33 ,@60 ,@12 ,@13, nil];
    NSArray *Corn2 = [[NSArray alloc] initWithObjects:@3.8 ,@0.38 ,@3.04 ,@3.04 ,@0.38 ,@0.38, @95 ,@33 ,@60 ,@12 ,@13, nil];
    NSArray *Corn3 = [[NSArray alloc] initWithObjects:@3.8 ,@0.38 ,@2.4 ,@2.4 ,@0.38 ,@0.38, @95 ,@33 ,@60 ,@12 ,@13, nil];
    NSArray *Corn4 = [[NSArray alloc] initWithObjects:@2 ,@0.2 ,@2.6 ,@2.6 ,@0.2 ,@0.2, @95 ,@33 ,@60 ,@12 ,@13, nil];
    
    NSArray *CornFactor = [[NSArray alloc] initWithObjects:@0.2 ,@0.015 ,@0.15 ,@0.05 ,@0.05 ,@0.02  ,@5 ,@5 ,@5 ,@2 ,@5, nil];
    
    //Cotton   Data
    NSArray *Cotton1 = [[NSArray alloc] initWithObjects:@3.6 ,@0.36 ,@2.88 ,@2.88 ,@0.36 ,@0.36 ,@104 ,@41 ,@48 ,@19 ,@62, nil];
    NSArray *Cotton2 = [[NSArray alloc] initWithObjects:@3.6 ,@0.36 ,@2.88 ,@2.88 ,@0.36 ,@0.36 ,@104 ,@41 ,@48 ,@19 ,@62, nil];
    NSArray *Cotton3 = [[NSArray alloc] initWithObjects:@3.2 ,@0.32 ,@2.56 ,@2.56 ,@0.32 ,@0.32, @104 ,@41 ,@48 ,@19 ,@62, nil];
    NSArray *Cotton4 = [[NSArray alloc] initWithObjects:@3 ,@0.3 ,@2.4 ,@2.4 ,@0.3 ,@0.3, @104 ,@41 ,@48 ,@19 ,@62, nil];
    
    NSArray *CottonFactor = [[NSArray alloc] initWithObjects:@0.2 ,@0.015 ,@0.15 ,@0.05 ,@0.05 ,@0.02  ,@5 ,@5 ,@5 ,@2 ,@5, nil];
    

    //Cucumbers   Data
    NSArray *Cucumbers1 = [[NSArray alloc] initWithObjects:@4 ,@0.4 ,@3.9 ,@3.2 ,@0.4 ,@0.4, @300 ,@48 ,@85 ,@16 ,@45, nil];
    NSArray *Cucumbers2 = [[NSArray alloc] initWithObjects:@4.4 ,@0.44 ,@3.52 ,@3.52 ,@0.44 ,@0.44, @300 ,@48 ,@85 ,@16 ,@45, nil];
    NSArray *Cucumbers3 = [[NSArray alloc] initWithObjects:@3.8 ,@0.4 ,@3.2 ,@3.2 ,@0.4 ,@0.4, @300 ,@48 ,@85 ,@16 ,@45, nil];
    NSArray *Cucumbers4 = [[NSArray alloc] initWithObjects:@3.4 ,@0.36 ,@3.2 ,@3.2 ,@0.4 ,@0.4, @300 ,@48 ,@85 ,@16 ,@45, nil];
    
    NSArray *CucumbersFactor = [[NSArray alloc] initWithObjects:@0.2 ,@0.015 ,@0.15 ,@0.05 ,@0.05 ,@0.02  ,@5 ,@5 ,@5 ,@2 ,@5, nil];
    
    //DryEdiblebBeans   Data
    NSArray *DryEdiblebBeans1 = [[NSArray alloc] initWithObjects:@4.2 ,@0.42 ,@3.36 ,@3.36 ,@0.42 ,@0.42, @135 ,@36 ,@83 ,@14 ,@42, nil];
    NSArray *DryEdiblebBeans2 = [[NSArray alloc] initWithObjects:@4.2 ,@0.42 ,@3.36 ,@3.36 ,@0.42 ,@0.42, @135 ,@36 ,@83 ,@14 ,@42, nil];
    NSArray *DryEdiblebBeans3 = [[NSArray alloc] initWithObjects:@4.2 ,@0.42 ,@3.36 ,@3.36 ,@0.42 ,@0.42, @135 ,@36 ,@83 ,@14 ,@42, nil];
    NSArray *DryEdiblebBeans4 = [[NSArray alloc] initWithObjects:@3.8 ,@0.38 ,@3.04 ,@3.04 ,@0.38 ,@0.38, @135 ,@36 ,@83 ,@14 ,@42, nil];
    
    NSArray *DryEdiblebBeansFactor = [[NSArray alloc] initWithObjects:@0.2 ,@0.015 ,@0.15 ,@0.05 ,@0.05 ,@0.02  ,@5 ,@5 ,@5 ,@2 ,@5, nil];
    
    //Grapes   Data
    NSArray *Grapes1 = [[NSArray alloc] initWithObjects:@2.7 ,@0.27 ,@2.2 ,@2.2 ,@0.27 ,@0.27, @75 ,@36 ,@70 ,@12 ,@31, nil];
    NSArray *Grapes2 = [[NSArray alloc] initWithObjects:@3 ,@0.3 ,@2.4 ,@2.4 ,@0.3 ,@0.3, @75 ,@36 ,@70 ,@12 ,@31, nil];
    NSArray *Grapes3 = [[NSArray alloc] initWithObjects:@2.8 ,@0.28 ,@2.6 ,@2.6 ,@0.28 ,@0.28, @75 ,@36 ,@70 ,@12 ,@31, nil];
    NSArray *Grapes4 = [[NSArray alloc] initWithObjects:@2.4 ,@0.24 ,@2.4 ,@2.4 ,@0.24 ,@0.24, @75 ,@36 ,@70 ,@12 ,@31, nil];
    
    NSArray *GrapesFactor = [[NSArray alloc] initWithObjects:@0.1 ,@0.008 ,@0.075 ,@0.025 ,@0.025 ,@0.01  ,@2.5 ,@2.5 ,@2.5 ,@1 ,@2.5, nil];
    
    //Onions   Data
    NSArray *Onions1 = [[NSArray alloc] initWithObjects:@3.4 ,@0.34 ,@2.72 ,@2.72 ,@0.34 ,@0.34, @90 ,@55 ,@75 ,@16 ,@27, nil];
    NSArray *Onions2 = [[NSArray alloc] initWithObjects:@3.8 ,@0.38 ,@3.04 ,@3.04 ,@0.38 ,@0.38, @90 ,@55 ,@75 ,@16 ,@27, nil];
    NSArray *Onions3 = [[NSArray alloc] initWithObjects:@3.4 ,@0.34 ,@2.72 ,@2.72 ,@0.34 ,@0.34, @90 ,@55 ,@75 ,@16 ,@27, nil];
    NSArray *Onions4 = [[NSArray alloc] initWithObjects:@3.1 ,@0.31 ,@3.1 ,@3.1 ,@0.31 ,@0.31, @90 ,@55 ,@75 ,@16 ,@27, nil];
    
    NSArray *OnionsFactor = [[NSArray alloc] initWithObjects:@0.2 ,@0.015 ,@0.15 ,@0.05 ,@0.05 ,@0.02  ,@5 ,@5 ,@5 ,@2 ,@5, nil];

    //Oranges   Data
    NSArray *Oranges1 = [[NSArray alloc] initWithObjects:@2.4 ,@0.24 ,@2.28 ,@2.28 ,@0.24 ,@0.24, @130 ,@60 ,@120 ,@15 ,@54, nil];
    NSArray *Oranges2 = [[NSArray alloc] initWithObjects:@2.8 ,@0.28 ,@2.48 ,@2.48 ,@0.28 ,@0.28, @130 ,@60 ,@120 ,@15 ,@54, nil];
    NSArray *Oranges3 = [[NSArray alloc] initWithObjects:@2.6 ,@0.26 ,@2.28 ,@2.28 ,@0.26 ,@0.26, @130 ,@60 ,@120 ,@15 ,@54, nil];
    NSArray *Oranges4 = [[NSArray alloc] initWithObjects:@2.6 ,@0.26 ,@2.28 ,@2.28 ,@0.26 ,@0.26, @130 ,@60 ,@120 ,@15 ,@54, nil];
    
    NSArray *OrangesFactor = [[NSArray alloc] initWithObjects:@0.1 ,@0.008 ,@0.075 ,@0.025 ,@0.025 ,@0.01  ,@2.5 ,@2.5 ,@2.5 ,@1 ,@2.5, nil];
    
    //Peach-Nectarine   Data
    NSArray *PeachNectarine1 = [[NSArray alloc] initWithObjects:@3.8 ,@0.38 ,@3.04 ,@3.04 ,@0.38 ,@0.38, @130 ,@40 ,@55 ,@12 ,@30, nil];
    NSArray *PeachNectarine2 = [[NSArray alloc] initWithObjects:@3.6 ,@0.36 ,@2.88 ,@2.88 ,@0.36 ,@0.36, @130 ,@40 ,@55 ,@12 ,@30, nil];
    NSArray *PeachNectarine3 = [[NSArray alloc] initWithObjects:@3.8 ,@0.38 ,@3.04 ,@3.04 ,@0.38 ,@0.38 ,@130 ,@40 ,@55 ,@12 ,@30, nil];
    NSArray *PeachNectarine4 = [[NSArray alloc] initWithObjects:@3.4 ,@0.34 ,@2.72 ,@2.72 ,@0.34 ,@0.34, @130 ,@40 ,@55 ,@12 ,@30, nil];
    
    NSArray *PeachNectarineFactor = [[NSArray alloc] initWithObjects:@0.1 ,@0.008 ,@0.075 ,@0.025 ,@0.025 ,@0.01  ,@2.5 ,@2.5 ,@2.5 ,@1 ,@2.5, nil];


    //Pecans   Data
    NSArray *Pecans1 = [[NSArray alloc] initWithObjects:@2.6 ,@0.26 ,@2.08 ,@2.08 ,@0.26 ,@0.26, @100 ,@48 ,@115 ,@25 ,@55, nil];
    NSArray *Pecans2 = [[NSArray alloc] initWithObjects:@3 ,@0.3 ,@2.4 ,@2.4 ,@0.3 ,@0.3, @100 ,@48 ,@115 ,@25 ,@55, nil];
    NSArray *Pecans3 = [[NSArray alloc] initWithObjects:@2.4 ,@0.24 ,@1.92 ,@1.92 ,@0.24 ,@0.24, @100 ,@48 ,@115 ,@25 ,@55, nil];
    NSArray *Pecans4 = [[NSArray alloc] initWithObjects:@3 ,@0.3 ,@2.4 ,@2.4 ,@0.3 ,@0.3, @100 ,@48 ,@115 ,@25 ,@55, nil];
    
    NSArray *PecansFactor = [[NSArray alloc] initWithObjects:@0.1 ,@0.008 ,@0.075 ,@0.025 ,@0.025 ,@0.01  ,@2.5 ,@2.5 ,@2.5 ,@1 ,@2.5, nil];

    //Potato   Data
    NSArray *Potato1 = [[NSArray alloc] initWithObjects:@5.4 ,@0.54 ,@4.32 ,@4.32 ,@0.54 ,@0.54, @135 ,@50 ,@120 ,@18 ,@35, nil];
    NSArray *Potato2 = [[NSArray alloc] initWithObjects:@6 ,@0.6 ,@4.8 ,@4.8 ,@0.6 ,@0.6, @135 ,@50 ,@120 ,@18 ,@35, nil];
    NSArray *Potato3 = [[NSArray alloc] initWithObjects:@4.9 ,@0.49 ,@4.8 ,@4.8 ,@0.54 ,@0.54, @135 ,@50 ,@120 ,@18 ,@35, nil];
    NSArray *Potato4 = [[NSArray alloc] initWithObjects:@4 ,@0.4 ,@4 ,@4 ,@0.4 ,@0.4, @135 ,@50 ,@120 ,@18 ,@35, nil];
    
    NSArray *PotatoFactor = [[NSArray alloc] initWithObjects:@0.2 ,@0.015 ,@0.15 ,@0.05 ,@0.05 ,@0.02  ,@5 ,@5 ,@5 ,@2 ,@5, nil];

    //Rice   Data
    NSArray *Rice1 = [[NSArray alloc] initWithObjects:@2.8 ,@0.28 ,@2.24 ,@2.24 ,@0.28 ,@0.28, @117 ,@42 ,@52 ,@10 ,@35, nil];
    NSArray *Rice2 = [[NSArray alloc] initWithObjects:@3.6 ,@0.36 ,@2.88 ,@2.88 ,@0.36 ,@0.36, @117 ,@42 ,@52 ,@10 ,@35, nil];
    NSArray *Rice3 = [[NSArray alloc] initWithObjects:@3.3 ,@0.33 ,@2.9 ,@2.9 ,@0.33 ,@0.33, @117 ,@42 ,@52 ,@10 ,@35, nil];
    NSArray *Rice4 = [[NSArray alloc] initWithObjects:@2.8 ,@0.28 ,@2.8 ,@2.8 ,@0.28 ,@0.28, @117 ,@42 ,@52 ,@10 ,@35, nil];
    
    NSArray *RiceFactor = [[NSArray alloc] initWithObjects:@0.2 ,@0.015 ,@0.15 ,@0.05 ,@0.05 ,@0.02  ,@5 ,@5 ,@5 ,@2 ,@5, nil];

    //Soybeans   Data
    NSArray *Soybeans1 = [[NSArray alloc] initWithObjects:@4.4 ,@0.44 ,@3.52 ,@3.52 ,@0.44 ,@0.44, @95 ,@39 ,@58 ,@13 ,@41, nil];
    NSArray *Soybeans2 = [[NSArray alloc] initWithObjects:@5.2 ,@0.52 ,@4.16 ,@4.16 ,@0.52 ,@0.52, @95 ,@39 ,@58 ,@13 ,@41, nil];
    NSArray *Soybeans3 = [[NSArray alloc] initWithObjects:@5.2 ,@0.52 ,@4.16 ,@4.16 ,@0.52 ,@0.52, @95 ,@39 ,@58 ,@13 ,@41, nil];
    NSArray *Soybeans4 = [[NSArray alloc] initWithObjects:@4.4 ,@0.44 ,@3.52 ,@3.52 ,@0.44 ,@0.44, @95 ,@39 ,@58 ,@13 ,@41, nil];
    
    NSArray *SoybeansFactor = [[NSArray alloc] initWithObjects:@0.2 ,@0.015 ,@0.15 ,@0.05 ,@0.05 ,@0.02  ,@5 ,@5 ,@5 ,@2 ,@5, nil];

    //Tomato   Data
    NSArray *Tomato1 = [[NSArray alloc] initWithObjects:@4.2 ,@0.42 ,@3.36 ,@3.36 ,@0.42 ,@0.42, @140 ,@40 ,@145 ,@20 ,@60, nil];
    NSArray *Tomato2 = [[NSArray alloc] initWithObjects:@4.6 ,@0.46 ,@3.68 ,@3.68 ,@0.46 ,@0.46, @140 ,@40 ,@145 ,@20 ,@60, nil];
    NSArray *Tomato3 = [[NSArray alloc] initWithObjects:@4.2 ,@0.42 ,@3.68 ,@3.68 ,@0.42 ,@0.42, @140 ,@40 ,@145 ,@20 ,@60, nil];
    NSArray *Tomato4 = [[NSArray alloc] initWithObjects:@3.2 ,@0.32 ,@3.2 ,@3.2 ,@0.32 ,@0.32, @140 ,@40 ,@145 ,@20 ,@60, nil];
    
    NSArray *TomatoFactor = [[NSArray alloc] initWithObjects:@0.2 ,@0.015 ,@0.15 ,@0.05 ,@0.05 ,@0.02  ,@5 ,@5 ,@5 ,@2 ,@5, nil];
    
    //Watermelon   Data
    NSArray *Watermelon1 = [[NSArray alloc] initWithObjects:@4.2 ,@0.42 ,@3.36 ,@3.36 ,@0.42 ,@0.42, @140 ,@48 ,@90 ,@16 ,@45, nil];
    NSArray *Watermelon2 = [[NSArray alloc] initWithObjects:@4.2 ,@0.42 ,@3.36 ,@3.36 ,@0.42 ,@0.42, @140 ,@48 ,@90 ,@16 ,@45, nil];
    NSArray *Watermelon3 = [[NSArray alloc] initWithObjects:@4.2 ,@0.42 ,@3.36 ,@3.36 ,@0.42 ,@0.42, @140 ,@48 ,@90 ,@16 ,@45, nil];
    NSArray *Watermelon4 = [[NSArray alloc] initWithObjects:@3.8 ,@0.38 ,@3.36 ,@3.36 ,@0.42 ,@0.42, @140 ,@48 ,@90 ,@16 ,@45, nil];
    
    NSArray *WatermelonFactor = [[NSArray alloc] initWithObjects:@0.2 ,@0.015 ,@0.15 ,@0.05 ,@0.05 ,@0.02  ,@5 ,@5 ,@5 ,@2 ,@5, nil];
    
    //Wheat   Data
    NSArray *Wheat1 = [[NSArray alloc] initWithObjects:@4 ,@0.4 ,@3.2 ,@3.2 ,@0.4 ,@0.4, @63 ,@36 ,@33 ,@10 ,@27, nil];
    NSArray *Wheat2 = [[NSArray alloc] initWithObjects:@4.5 ,@0.45 ,@3.6 ,@3.6 ,@0.45 ,@0.45, @63 ,@36 ,@33 ,@10 ,@27, nil];
    NSArray *Wheat3 = [[NSArray alloc] initWithObjects:@4 ,@0.4 ,@3.6 ,@3.6 ,@0.45 ,@0.45, @63 ,@36 ,@33 ,@10 ,@27, nil];
    NSArray *Wheat4 = [[NSArray alloc] initWithObjects:@3.2 ,@0.32 ,@2.56 ,@2.56 ,@0.32 ,@0.32, @63 ,@36 ,@33 ,@10 ,@27, nil];
    
    NSArray *WheatFactor = [[NSArray alloc] initWithObjects:@0.2 ,@0.015 ,@0.15 ,@0.05 ,@0.05 ,@0.02  ,@5 ,@5 ,@5 ,@2 ,@5, nil];
    
    
    NSArray *allCropDetails = [[NSArray alloc] initWithObjects:
                               Almonds1,Almonds2,Almonds3,Almonds4,AlmondsFactor,
                               Apples1, Apples2, Apples3, Apples4, ApplesFactor,
                               Cantaloupe1, Cantaloupe2, Cantaloupe3, Cantaloupe4, CantaloupeFactor,
                               Chilipeppers1, Chilipeppers2, Chilipeppers3, Chilipeppers4, ChilipeppersFactor,
                               Corn1, Corn2, Corn3, Corn4, CornFactor,
                               Cotton1, Cotton2, Cotton3, Cotton4, CottonFactor,
                               Cucumbers1, Cucumbers2, Cucumbers3, Cucumbers4, CucumbersFactor,
                               DryEdiblebBeans1, DryEdiblebBeans2, DryEdiblebBeans3, DryEdiblebBeans4, DryEdiblebBeansFactor,
                               Grapes1, Grapes2, Grapes3, Grapes4, GrapesFactor,
                               Onions1, Onions2, Onions3, Onions4, OnionsFactor,
                               Oranges1, Oranges2, Oranges3, Oranges4, OrangesFactor,
                               PeachNectarine1, PeachNectarine2, PeachNectarine3, PeachNectarine4, PeachNectarineFactor,
                               Pecans1, Pecans2, Pecans3, Pecans4, PecansFactor,
                               Potato1, Potato2, Potato3, Potato4, PotatoFactor,
                               Rice1, Rice2, Rice3, Rice4, RiceFactor,
                               Soybeans1, Soybeans2, Soybeans3, Soybeans4, SoybeansFactor,
                               Tomato1, Tomato2, Tomato3, Tomato4, TomatoFactor,
                               Watermelon1, Watermelon2, Watermelon3, Watermelon4, WatermelonFactor,
                               Wheat1, Wheat2, Wheat3, Wheat4, WheatFactor,
                               nil];

    NSArray *keys = [[NSArray alloc] initWithObjects:
                     @"Almonds1",@"Almonds2",@"Almonds3",@"Almonds4",@"AlmondsFactor",
                     @"Apples1", @"Apples2", @"Apples3", @"Apples4", @"ApplesFactor",
                     @"Cantaloupe1", @"Cantaloupe2", @"Cantaloupe3", @"Cantaloupe4", @"CantaloupeFactor",
                     @"Chilipeppers1", @"Chilipeppers2", @"Chilipeppers3", @"Chilipeppers4", @"ChilipeppersFactor",
                     @"Corn1", @"Corn2", @"Corn3", @"Corn4", @"CornFactor",
                     @"Cotton1", @"Cotton2", @"Cotton3", @"Cotton4", @"CottonFactor",
                     @"Cucumbers1", @"Cucumbers2", @"Cucumbers3", @"Cucumbers4", @"CucumbersFactor",
                     @"DryEdibleBeans1", @"DryEdibleBeans2", @"DryEdibleBeans3", @"DryEdibleBeans4", @"DryEdibleBeansFactor",
                     @"Grapes1", @"Grapes2", @"Grapes3", @"Grapes4", @"GrapesFactor",
                     @"Onions1", @"Onions2", @"Onions3", @"Onions4", @"OnionsFactor",
                     @"Oranges1", @"Oranges2", @"Oranges3", @"Oranges4", @"OrangesFactor",
                     @"PeachNectarine1", @"PeachNectarine2", @"PeachNectarine3", @"PeachNectarine4", @"PeachNectarineFactor",
                     @"Pecans1", @"Pecans2", @"Pecans3", @"Pecans4", @"PecansFactor",
                     @"Potato1", @"Potato2", @"Potato3", @"Potato4", @"PotatoFactor",
                     @"Rice1", @"Rice2", @"Rice3", @"Rice4", @"RiceFactor",
                     @"Soybeans1", @"Soybeans2", @"Soybeans3", @"Soybeans4", @"SoybeansFactor",
                     @"Tomato1", @"Tomato2", @"Tomato3", @"Tomato4", @"TomatoFactor",
                     @"Watermelon1", @"Watermelon2", @"Watermelon3", @"Watermelon4", @"WatermelonFactor",
                     @"Wheat1", @"Wheat2", @"Wheat3", @"Wheat4", @"WheatFactor",
                     nil];
    
    self.BHNData = [[NSDictionary alloc] initWithObjects:allCropDetails forKeys:keys];
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
