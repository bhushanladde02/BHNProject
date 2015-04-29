//
//  SecondViewController.m
//  BHN
//
//  Created by William Grey on 6/25/14.
//  Copyright (c) 2014 BHN. All rights reserved.
//

#import "SecondViewController.h"
#import "FirstViewController.h"
#import "Utils.h"
#import "ProductTableViewCell.h"
#import "TPKeyboardAvoidingScrollView.h"
#import "AppDelegate.h"
#import "FourthViewController.h"
#import "AFHTTPRequestOperation.h"

NSMutableArray *soilFertilityTableData;
NSMutableArray *plantGrowthManagementTableData;
NSMutableArray *macronutrientsTableData;
NSMutableArray *micronutrientsTableData;
NSMutableArray *carbonRichOrganicAcidsTableData;

NSMutableArray *soilFertilityLabelData;
NSMutableArray *plantGrowthManagementLabelData;
NSMutableArray *macronutrientsLabelData;
NSMutableArray *micronutrientsLabelData;
NSMutableArray *carbonRichOrganicAcidsLabelData;


NSMutableArray *soilFertilitySDSData;
NSMutableArray *plantGrowthManagementSDSData;
NSMutableArray *macronutrientsSDSData;
NSMutableArray *micronutrientsSDSData;
NSMutableArray *carbonRichOrganicAcidsSDSData;



NSMutableArray *headerColorArray;
NSMutableArray *cellColorArray;

@interface SecondViewController ()

@end


@implementation SecondViewController

@synthesize   menuVC, navController;

- (NSMutableArray*) populateSubTable:(NSString*)productName fromDictionary:(NSDictionary*)productList  {
    
    NSMutableArray *output = [[NSMutableArray alloc]init];
    
    NSMutableArray *valueArray = [productList valueForKey:productName];
    NSMutableArray* name =[[NSMutableArray alloc] init];
    for (NSDictionary *object in valueArray) {
        NSLog(@"value for %@",[object objectForKey:@"name"]);
        [name addObject: [object objectForKey:@"name"]];
    }
    
    NSMutableArray* labelLinks =[[NSMutableArray alloc] init];
    for (NSDictionary *object in valueArray) {
        NSLog(@"value for %@",[object objectForKey:@"imageurl"]);
        [labelLinks addObject: [object objectForKey:@"imageurl"]];
    }
    
    NSMutableArray* sdsLinks =[[NSMutableArray alloc] init];
    for (NSDictionary *object in valueArray) {
        NSLog(@"value for %@",[object objectForKey:@"sdfPath"]);
        [sdsLinks addObject: [object objectForKey:@"sdfPath"]];
    }
    
    [output addObject:name];
    [output addObject:labelLinks];
    [output addObject:sdsLinks];
    
    
    return output;

}


- (void)viewDidLoad
{
    [super viewDidLoad];
    
    
    NSArray *paths = NSSearchPathForDirectoriesInDomains
    (NSDocumentDirectory, NSUserDomainMask, YES);
    NSString *documentsDirectory = [paths objectAtIndex:0];
    
    NSString *filePath = [documentsDirectory stringByAppendingPathComponent:@"productList.json"];
    
    if ([[NSFileManager defaultManager] fileExistsAtPath:filePath])
    {
        NSData *data = [NSData dataWithContentsOfFile:filePath];
        if (data.length > 0) {
            NSDictionary *dictionary = [NSJSONSerialization JSONObjectWithData:data options:0 error:nil];
            NSDictionary *productList = [dictionary valueForKey:@"hash"];
            
            /*NSMutableArray *valueArray = [productList valueForKey:@"MACRONUTRIENTS"];
            macronutrientsTableData =[[NSMutableArray alloc] init];
            for (NSDictionary *object in valueArray) {
                NSLog(@"value for %@",[object objectForKey:@"name"]);
                [macronutrientsTableData addObject: [object objectForKey:@"name"]];
            }*/
            
            NSMutableArray *result;
            
            result = [self populateSubTable:@"MACRONUTRIENTS" fromDictionary:productList];
            macronutrientsTableData = [result objectAtIndex:0];
            macronutrientsLabelData = [result objectAtIndex:1];
            macronutrientsSDSData = [result objectAtIndex:2];
            
            result = [self populateSubTable:@"MICRONUTRIENTS" fromDictionary:productList];
            micronutrientsTableData = [result objectAtIndex:0];
            micronutrientsLabelData = [result objectAtIndex:1];
            micronutrientsSDSData = [result objectAtIndex:2];
            
            result = [self populateSubTable:@"SUSTAINABLE SOIL FERTILITY" fromDictionary:productList];
            soilFertilityTableData = [result objectAtIndex:0];
            soilFertilityLabelData = [result objectAtIndex:1];
            soilFertilitySDSData = [result objectAtIndex:2];
            
            result = [self populateSubTable:@"PLANT GROWTH MANAGEMENT" fromDictionary:productList];
            plantGrowthManagementTableData = [result objectAtIndex:0];
            plantGrowthManagementLabelData = [result objectAtIndex:1];
            plantGrowthManagementSDSData = [result objectAtIndex:2];
            
            result = [self populateSubTable:@"CARBON-RICH ORGANIC ACIDS" fromDictionary:productList];
            carbonRichOrganicAcidsTableData = [result objectAtIndex:0];
            carbonRichOrganicAcidsLabelData = [result objectAtIndex:1];
            carbonRichOrganicAcidsSDSData = [result objectAtIndex:2];
            
        }
    }else
    {
        //download json file from server
        //check internet connection
        
        NSURLRequest *request = [NSURLRequest requestWithURL:[NSURL URLWithString:@"http://104.130.240.26:8080/bhn/service/products/"]];
        AFHTTPRequestOperation *operation = [[AFHTTPRequestOperation alloc] initWithRequest:request];
        
        NSArray *paths = NSSearchPathForDirectoriesInDomains(NSDocumentDirectory, NSUserDomainMask, YES);
        NSString *path = [[paths objectAtIndex:0] stringByAppendingPathComponent:@"productList.json"];
        operation.outputStream = [NSOutputStream outputStreamToFileAtPath:path append:NO];
        
        [operation setCompletionBlockWithSuccess:^(AFHTTPRequestOperation *operation, id responseObject) {
            NSLog(@"Successfully downloaded file to %@", path);
            
        } failure:^(AFHTTPRequestOperation *operation, NSError *error) {
            NSLog(@"Error: %@", error);
        }];
        
        [operation start];
        
    }
    
    
    //fetch the product list which was received from the web-service call
    AppDelegate *delegate = [[UIApplication sharedApplication] delegate];
    NSDictionary *dict = delegate.productList;
    
    int count = 0;
    
    for (NSObject *obj in dict)
    {
        count++;
    }
    
    for (NSString *key in [dict allKeys]) {
        NSLog(@"key: %@", key);
    }
    
    NSLog(@"received %d objects", count);
    

    //RK: added logo in navigation bar

//    UIButton* BHNLogo = (UIButton *) [[UIImageView alloc] initWithImage:[UIImage imageNamed:@"header icons_44-01.png"]];
//    UIBarButtonItem *BHNLogoItem = [[UIBarButtonItem alloc] initWithCustomView:BHNLogo   target:self action:@selector(oepnDrawerMenu:) ];
//    self.navigationItem.rightBarButtonItem = BHNLogoItem;
    
//    UIBarButtonItem *BHNLogoItem = [[UIBarButtonItem alloc] initWithImage:[UIImage imageNamed:@"header icons_44-01.png"] style:UIBarButtonItemStylePlain target:self action:@selector(openDrawerMenu:)];
//
//    
//    self.navigationItem.rightBarButtonItem = BHNLogoItem;

    
    TPKeyboardAvoidingScrollView* scrollView = [[TPKeyboardAvoidingScrollView alloc] initWithFrame:CGRectMake(0, 0, self.view.bounds.size.width, self.view.bounds.size.height)];
    scrollView.scrollEnabled = YES;
    //scrollView.pagingEnabled = YES;
    scrollView.showsVerticalScrollIndicator = YES;
    scrollView.showsHorizontalScrollIndicator = YES;
    scrollView.contentSize = CGSizeMake(self.view.bounds.size.width, self.view.bounds.size.height*3.5);
    //[self.view addSubview:scrollView];
    self.view = scrollView;
    
    headerColorArray = [[NSMutableArray alloc] initWithObjects:@"402510",@"069e48",@"137fc2",@"fcb932",@"f05129",@"4b4b4d", nil];
   
    cellColorArray =[[NSMutableArray alloc] initWithObjects:@"bdaea4",@"cbdec8",@"c3d1eb",@"ffeac9",@"facfb9",@"bfbdbe", nil];
    
    //soilFertilityTableData = [[NSMutableArray alloc] initWithObjects:@"CALCIUM",@"C-PHOS",@"GOLDEN GRO",nil];
    //plantGrowthManagementTableData = [[NSMutableArray alloc] initWithObjects:@"ACALCIUM",@"B-PHOS",@"KOLDEN DDRO",nil];
    //macronutrientsTableData = [[NSMutableArray alloc] initWithObjects:@"SUPER NITRO",@"SUPER PHOS",@"SUPER K",nil];
    //micronutrientsTableData= [[NSMutableArray alloc] initWithObjects:@"44 MAG",@"BORON",@"BORO-MAX",@"CALCIUM",nil];
    //zeroResidueCropProtectionTableData = [[NSMutableArray alloc] initWithObjects:@"PROUD 3",@"PROMAX",nil];
    //carbonRichOrganicAcidsTableData = [[NSMutableArray alloc] initWithObjects:@"X-TEND® CON",@"X-TEND® B-CON",@"FULVI PRO™",@"HUMA BURST™",@"HUMA PRO™",nil];
    
    // Do any additional setup after loading the view.
    [self.view setBackgroundColor:[Utils colorWithHexString:@"e8e8e8"]];
    self.navigationController.navigationBar.translucent = NO;
    self.navigationController.navigationBar.tintColor = [Utils colorWithHexString:@"149c46"];
    self.navigationController.navigationBar.barTintColor = [Utils colorWithHexString:@"149c46"];
    
    
    CGRect frame = CGRectMake(0, 0, 400, 44);
    UILabel *label = [[UILabel alloc] initWithFrame:frame];
    label.font = [UIFont boldSystemFontOfSize:14.0];
    label.textAlignment = NSTextAlignmentCenter;
    label.textColor = [UIColor whiteColor];
    label.text = @"Product Information";
    
    self.navigationItem.titleView = label;
    
    

    CGRect screenRect = [[UIScreen mainScreen] bounds];
    CGFloat screenWidth = screenRect.size.width;
    CGFloat screenHeight = screenRect.size.height;
    
    
    self.navigationItem.titleView = label;
    
   /* UILabel *locationLabel = [[UILabel alloc] initWithFrame:CGRectMake(0, screenHeight*0.10, screenWidth, screenHeight*0.05)];
    locationLabel.text = @"Location";
    [locationLabel sizeToFit];
    [locationLabel setCenter:CGPointMake(screenWidth/2, screenHeight*0.10)];
    [self.view addSubview:locationLabel];
    
    UIView *locationBar =[[UIView alloc] initWithFrame:CGRectMake( 0 , screenHeight*0.15, screenWidth, screenHeight*0.05)];
    [locationBar setBackgroundColor:[Utils colorWithHexString:@"d2d3d4"]];
    
    
    UITextView *textViewOne = [[UITextView alloc] initWithFrame:CGRectMake(0, 0, screenWidth*0.5, screenHeight*0.05)];
    [textViewOne setCenter:CGPointMake(screenWidth/2, screenHeight*0.05/2)];
    [textViewOne setTextAlignment:NSTextAlignmentCenter];
    [textViewOne setTextColor:[Utils colorWithHexString:@"447fc2" ]];
    [textViewOne setText :@"Select"];
    textViewOne.font = [UIFont boldSystemFontOfSize:16.0];
    //[textViewOne.layer setBorderWidth:1];
    
    [locationBar addSubview:textViewOne];
    */

    CGFloat rowHeight = 42;
    
    
    UIView *soilFertilityBar =[[UIView alloc] initWithFrame:CGRectMake( 0 , 0, screenWidth, screenHeight*0.06)];
    [soilFertilityBar setBackgroundColor:[Utils colorWithHexString:[headerColorArray objectAtIndex:0]]];
    
    UILabel *soilFertilityLabel = [[UILabel alloc] initWithFrame:CGRectMake(0, 0, screenWidth, screenHeight*0.05)];
    [soilFertilityLabel setCenter:CGPointMake(screenWidth/2, screenHeight*0.05/2)];
    [soilFertilityLabel setTextAlignment:NSTextAlignmentCenter];
    [soilFertilityLabel setTextColor:[Utils colorWithHexString:@"ffffff" ]];
    [soilFertilityLabel setText :@"SUSTAINABLE SOIL FERTILITY"];
    soilFertilityLabel.font = [UIFont boldSystemFontOfSize:16.0];
    
    [soilFertilityBar addSubview:soilFertilityLabel];

    CGFloat offset =screenHeight*0.06;
    
    soilFertility = [[UITableView alloc] initWithFrame:CGRectMake(0, offset, screenWidth, rowHeight*soilFertilityTableData.count)];
    soilFertility.backgroundColor = [Utils colorWithHexString:@"e8e8e8"];
    soilFertility.dataSource = self;
    soilFertility.rowHeight = rowHeight;
    
    offset = offset + soilFertility.frame.size.height;
    
    UIView *plantGrowthBar =[[UIView alloc] initWithFrame:CGRectMake( 0 , offset, screenWidth, screenHeight*0.06)];
    [plantGrowthBar setBackgroundColor:[Utils colorWithHexString:[headerColorArray objectAtIndex:1]]];
    
    UILabel *plantGrowthBarLabel = [[UILabel alloc] initWithFrame:CGRectMake(0, 0, screenWidth, screenHeight*0.05)];
    [plantGrowthBarLabel setCenter:CGPointMake(screenWidth/2, screenHeight*0.05/2)];
    [plantGrowthBarLabel setTextAlignment:NSTextAlignmentCenter];
    [plantGrowthBarLabel setTextColor:[Utils colorWithHexString:@"ffffff" ]];
    [plantGrowthBarLabel setText :@"PLANT GROWTH MANAGEMENT"];
    plantGrowthBarLabel.font = [UIFont boldSystemFontOfSize:16.0];
    
    [plantGrowthBar addSubview:plantGrowthBarLabel];
    
    offset = offset + screenHeight*0.05;
    
    plantGrowthManagement =[[UITableView alloc] initWithFrame:CGRectMake(0, offset, screenWidth, rowHeight*plantGrowthManagementTableData.count)];
    plantGrowthManagement.backgroundColor = [Utils colorWithHexString:@"e8e8e8"];
    plantGrowthManagement.dataSource = self;
    plantGrowthManagement.rowHeight = rowHeight;
    
    offset = offset + plantGrowthManagement.frame.size.height;
    
    UIView *macroNutrientBar =[[UIView alloc] initWithFrame:CGRectMake( 0 , offset, screenWidth, screenHeight*0.06)];
    [macroNutrientBar setBackgroundColor:[Utils colorWithHexString:[headerColorArray objectAtIndex:2]]];
    
    
    UILabel *macroNutrientLabel = [[UILabel alloc] initWithFrame:CGRectMake(0, 0, screenWidth, screenHeight*0.05)];
    [macroNutrientLabel setCenter:CGPointMake(screenWidth/2, screenHeight*0.05/2)];
    [macroNutrientLabel setTextAlignment:NSTextAlignmentCenter];
    [macroNutrientLabel setTextColor:[Utils colorWithHexString:@"ffffff" ]];
    [macroNutrientLabel setText :@"MACRONUTIRENTS"];
    macroNutrientLabel.font = [UIFont boldSystemFontOfSize:16.0];
    
    [macroNutrientBar addSubview:macroNutrientLabel];
    offset = offset + screenHeight*0.05;
    
    macronutrients =[[UITableView alloc] initWithFrame:CGRectMake(0, offset, screenWidth, rowHeight*macronutrientsTableData.count)];
    macronutrients.backgroundColor = [Utils colorWithHexString:@"e8e8e8"];
    macronutrients.dataSource = self;
    macronutrients.rowHeight = rowHeight;
    
    offset = offset + macronutrients.frame.size.height;
    
    UIView *microNutrientBar =[[UIView alloc] initWithFrame:CGRectMake( 0 , offset, screenWidth, screenHeight*0.06)];
    [microNutrientBar setBackgroundColor:[Utils colorWithHexString:[headerColorArray objectAtIndex:3]]];
    
    UILabel *microNutrientLabel = [[UILabel alloc] initWithFrame:CGRectMake(0, 0, screenWidth, screenHeight*0.05)];
    [microNutrientLabel setCenter:CGPointMake(screenWidth/2, screenHeight*0.05/2)];
    [microNutrientLabel setTextAlignment:NSTextAlignmentCenter];
    [microNutrientLabel setTextColor:[Utils colorWithHexString:@"ffffff" ]];
    [microNutrientLabel setText :@"MICRONUTIRENTS"];

    [microNutrientBar addSubview:microNutrientLabel];
    offset = offset + screenHeight*0.05;
    
    micronutrients=[[UITableView alloc] initWithFrame:CGRectMake(0, offset, screenWidth, rowHeight*micronutrientsTableData.count)];
    micronutrients.backgroundColor = [Utils colorWithHexString:@"e8e8e8"];
    micronutrients.dataSource = self;
    micronutrients.rowHeight = rowHeight;
    
    offset = offset + micronutrients.frame.size.height;
    
    
    /*UIView *zeroResidueCropBar =[[UIView alloc] initWithFrame:CGRectMake( 0 , offset, screenWidth, screenHeight*0.06)];
    [zeroResidueCropBar setBackgroundColor:[Utils colorWithHexString:[headerColorArray objectAtIndex:4]]];
    
    UILabel *zeroResidueCropBarLabel = [[UILabel alloc] initWithFrame:CGRectMake(0, 0, screenWidth, screenHeight*0.05)];
    [zeroResidueCropBarLabel setCenter:CGPointMake(screenWidth/2, screenHeight*0.05/2)];
    [zeroResidueCropBarLabel setTextAlignment:NSTextAlignmentCenter];
    [zeroResidueCropBarLabel setTextColor:[Utils colorWithHexString:@"ffffff" ]];
    [zeroResidueCropBarLabel setText :@"ZERO-RESIDUE-CROP PROTECTION"];
    
    [zeroResidueCropBar addSubview:zeroResidueCropBarLabel];
    offset = offset + screenHeight*0.05;

    //calculate height using
    zeroResidueCrop=[[UITableView alloc] initWithFrame:CGRectMake(0, offset, screenWidth, rowHeight*zeroResidueCropProtectionTableData.count)];
    zeroResidueCrop.backgroundColor = [Utils colorWithHexString:@"e8e8e8"];
    zeroResidueCrop.dataSource = self;
    zeroResidueCrop.rowHeight = rowHeight;
    
    offset = offset + zeroResidueCrop.frame.size.height;*/
    
    
    UIView *carbonRichOrganicAcidsBar =[[UIView alloc] initWithFrame:CGRectMake( 0 , offset, screenWidth, screenHeight*0.06)];
    [carbonRichOrganicAcidsBar setBackgroundColor:[Utils colorWithHexString:[headerColorArray objectAtIndex:5]]];
    
    UILabel *carbonRichOrganicAcidLabel = [[UILabel alloc] initWithFrame:CGRectMake(0, 0, screenWidth, screenHeight*0.05)];
    [carbonRichOrganicAcidLabel setCenter:CGPointMake(screenWidth/2, screenHeight*0.05/2)];
    [carbonRichOrganicAcidLabel setTextAlignment:NSTextAlignmentCenter];
    [carbonRichOrganicAcidLabel setTextColor:[Utils colorWithHexString:@"ffffff" ]];
    [carbonRichOrganicAcidLabel setText :@"CARBON-RICH ORGANIC ACIDS"];
    
    [carbonRichOrganicAcidsBar addSubview:carbonRichOrganicAcidLabel];
    offset = offset + screenHeight*0.05;

    carbonRichOrganicAcids=[[UITableView alloc] initWithFrame:CGRectMake(0, offset, screenWidth, rowHeight*carbonRichOrganicAcidsTableData.count)];
    carbonRichOrganicAcids.backgroundColor = [Utils colorWithHexString:@"e8e8e8"];
    carbonRichOrganicAcids.dataSource = self;
    carbonRichOrganicAcids.rowHeight = rowHeight;
    
    offset = offset + carbonRichOrganicAcids.frame.size.height;
    
   // [self.view addSubview:locationBar];
    [self.view addSubview:soilFertilityBar];
    [self.view addSubview:soilFertility];
    [self.view addSubview:plantGrowthBar];
    [self.view addSubview:plantGrowthManagement];
    [self.view addSubview:macroNutrientBar];
    [self.view addSubview:macronutrients];
    [self.view addSubview:microNutrientBar];
    [self.view addSubview:micronutrients];
   // [self.view addSubview:zeroResidueCropBar];
   // [self.view addSubview:zeroResidueCrop];
    [self.view addSubview:carbonRichOrganicAcidsBar];
    [self.view addSubview:carbonRichOrganicAcids];
    
    //iphone, dismiss keyboard when touching outside of textfield
    UITapGestureRecognizer *tap = [[UITapGestureRecognizer alloc]
                                   initWithTarget:self
                                   action:@selector(dismissKeyboard)];
    [self.view addGestureRecognizer:tap];
    
    
    

    
    CGRect labelframe = CGRectMake(0, 0, screenWidth/2, 44);
    UILabel *titlelabel = [[UILabel alloc] initWithFrame:labelframe];
    titlelabel.font = [UIFont boldSystemFontOfSize:14.0];
    titlelabel.textAlignment = NSTextAlignmentCenter;
    titlelabel.textColor = [UIColor whiteColor];
    titlelabel.text = @"Products";
    
    UIButton* BHNLogo = (UIButton *) [[UIImageView alloc] initWithImage:[UIImage imageNamed:@"header icons_44-01.png"]];
    UIBarButtonItem *BHNLogoItem = [[UIBarButtonItem alloc] initWithCustomView:BHNLogo];
    self.navigationItem.leftBarButtonItem = BHNLogoItem;
    
    self.navigationController.navigationItem.backBarButtonItem.tintColor = [UIColor whiteColor];
    self.navigationController.navigationBar.backItem.title = @"";
    self.navigationItem.titleView = titlelabel;
    self.navigationItem.leftBarButtonItem = BHNLogoItem;
    
    self.navigationController.navigationItem.backBarButtonItem.tintColor = [UIColor whiteColor];
    self.navigationController.navigationBar.backItem.title = @"";
    
    //adding menu on top right corner
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


-(void)openDrawerMenu:(id)sender{
    NSLog(@"received %d objects", 3);
    
    /*UIViewController * leftDrawer = [[FourthViewController alloc] init];
    UIViewController * center = [[FourthViewController alloc] init];
    UIViewController * rightDrawer = [[FourthViewController alloc] init];
    
    MMDrawerController * drawerController = [[MMDrawerController alloc]
                                             initWithCenterViewController:center
                                             leftDrawerViewController:leftDrawer
                                             rightDrawerViewController:rightDrawer];
    
    [self.navigationController pushViewController:drawerController animated:TRUE];
     */
    
}


#pragma mark Table view methods

- (NSInteger)numberOfSectionsInTableView:(UITableView *)tableView {
    return 1;
}


// Customize the number of rows in the table view.
- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section {
    if(tableView == soilFertility)
        return soilFertilityTableData.count;
    else if(tableView == plantGrowthManagement)
        return plantGrowthManagementTableData.count;
    else if(tableView == macronutrients)
        return macronutrientsTableData.count;
    else if(tableView == micronutrients)
        return micronutrientsTableData.count;
 //   else if(tableView == zeroResidueCrop)
  //      return zeroResidueCropProtectionTableData.count;
    else if(tableView == carbonRichOrganicAcids)
        return carbonRichOrganicAcidsTableData.count;
    else
        return 0;
}
/*
-(void) openSDSFile:(id) sender {
    
    
    NSURLRequest *request = [NSURLRequest requestWithURL:[NSURL URLWithString:@"http://onine.in/sdspdf/CAipccreg.form.pdf"]];
    AFHTTPRequestOperation *operation = [[AFHTTPRequestOperation alloc] initWithRequest:request];
    
    NSArray *paths = NSSearchPathForDirectoriesInDomains(NSDocumentDirectory, NSUserDomainMask, YES);
    NSString *path = [[paths objectAtIndex:0] stringByAppendingPathComponent:@"filename.pdf"];
    operation.outputStream = [NSOutputStream outputStreamToFileAtPath:path append:NO];
    
    [operation setCompletionBlockWithSuccess:^(AFHTTPRequestOperation *operation, id responseObject) {
        NSLog(@"Successfully downloaded file to %@", path);
        
        NSURL *URL = [NSURL fileURLWithPath:path];
        if (URL)
        {
            documentInteractionController = [UIDocumentInteractionController interactionControllerWithURL:URL];
            documentInteractionController.delegate = self;
            
            // Present "Open In Menu"
            [documentInteractionController presentOpenInMenuFromRect:[sender frame] inView:self.view animated:YES];
        }
        
        
    } failure:^(AFHTTPRequestOperation *operation, NSError *error) {
        NSLog(@"Error: %@", error);
    }];
    
    [operation start];
}

-(void) openImageFile:(id) sender  forLabel:(NSString*) labelURL {
    
    
    NSURLRequest *request = [NSURLRequest requestWithURL:[NSURL URLWithString:labelURL]];
    AFHTTPRequestOperation *operation = [[AFHTTPRequestOperation alloc] initWithRequest:request];
    
    NSArray *paths = NSSearchPathForDirectoriesInDomains(NSDocumentDirectory, NSUserDomainMask, YES);
    NSString *path = [[paths objectAtIndex:0] stringByAppendingPathComponent:@"filename1.jpg"];
    operation.outputStream = [NSOutputStream outputStreamToFileAtPath:path append:NO];
    
    [operation setCompletionBlockWithSuccess:^(AFHTTPRequestOperation *operation, id responseObject) {
        NSLog(@"Successfully downloaded file to %@", path);
        
        NSURL *URL = [NSURL fileURLWithPath:path];
        if (URL)
        {
            documentInteractionController = [UIDocumentInteractionController interactionControllerWithURL:URL];
            documentInteractionController.delegate = self;
            
            // Present "Open In Menu"
            [documentInteractionController presentOpenInMenuFromRect:[sender frame] inView:self.view animated:YES];
        }
        
        
    } failure:^(AFHTTPRequestOperation *operation, NSError *error) {
        NSLog(@"Error: %@", error);
    }];
    
    [operation start];
}*/




// Customize the appearance of table view cells.
- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath {
    
    static NSString *CellIdentifier = @"Cell";
    
    ProductTableViewCell *pcell = (ProductTableViewCell *) [tableView dequeueReusableCellWithIdentifier:CellIdentifier];
    if(pcell == nil){
        NSArray* topLevelObjects =[[NSBundle mainBundle ]loadNibNamed:@"ProductTableViewCell" owner:self options:nil];
        for (id currentObject in topLevelObjects) {
            if ([currentObject isKindOfClass:[ProductTableViewCell class]]) {
                pcell = (ProductTableViewCell *)currentObject;
                
                NSArray *tableData;
                NSArray *labelData;
                NSArray *sdsData;
                
                NSInteger index =0;
                if(tableView == soilFertility){
                    tableData = soilFertilityTableData;
                    labelData = soilFertilityLabelData;
                    sdsData = soilFertilitySDSData;
                    
                    index = 0;
                }
                else if(tableView == plantGrowthManagement){
                    tableData = plantGrowthManagementTableData;
                    labelData = plantGrowthManagementLabelData;
                    sdsData = plantGrowthManagementSDSData;
                    
                    index = 1;
                }
                else if(tableView == macronutrients){
                    tableData = macronutrientsTableData;
                    labelData = macronutrientsLabelData;
                    sdsData = macronutrientsSDSData;
                    
                    index = 2;
                }
                else if(tableView == micronutrients){
                    tableData = micronutrientsTableData;
                    labelData = micronutrientsLabelData;
                    sdsData = micronutrientsSDSData;
                    
                    index = 3;
                }
         //       else if(tableView == zeroResidueCrop){
          //          tableData = zeroResidueCropProtectionTableData;
           //         index = 4;
          //      }
                else{
                    tableData = carbonRichOrganicAcidsTableData;
                    labelData = carbonRichOrganicAcidsLabelData;
                    sdsData = carbonRichOrganicAcidsSDSData;
                    
                    index = 4;
                }
                
                [pcell setFirstColumnName: [tableData objectAtIndex:indexPath.row]];
                
                pcell.labelUrl = [labelData objectAtIndex:indexPath.row];
                pcell.sdsUrl = [sdsData objectAtIndex:indexPath.row];
                pcell.parentView = self.view;
                
               // [[pcell labelButton] addTarget:self action:@selector(openImageFile:forLabel:) forControlEvents:UIControlEventTouchUpInside];
                
               // [[pcell sdsButton] addTarget:self action:@selector(openSDSFile:) forControlEvents:UIControlEventTouchUpInside];
                
                
                
                //[pcell.labelButton set]
                [pcell.contentView.layer setBorderColor:[UIColor yellowColor].CGColor];
                [pcell setBackgroundColor: [Utils colorWithHexString: [cellColorArray objectAtIndex:index ]]];
                
                break;
            }
        }
        
    }
    
  
    return pcell;
    
}

- (void)tableView:(UITableView *)tableView didSelectRowAtIndexPath:(NSIndexPath *)indexPath {
    // open a alert with an OK and cancel button
	/*NSString *alertString = [NSString stringWithFormat:@"Clicked on row #%d", [indexPath row]];
	UIAlertView *alert = [[UIAlertView alloc] initWithTitle:alertString message:@"" delegate:self cancelButtonTitle:@"Done" otherButtonTitles:nil];
	[alert show];*/
}

-(CGFloat)tableView:(UITableView *)tableView heightForRowAtIndexPath:(NSIndexPath *)indexPath
{
    return 42;
}


-(void)dismissKeyboard {
    [self.view endEditing:YES];
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

@end
