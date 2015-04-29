//
//  ResultsViewController.m
//  BHN
//
//  Created by Rohit Kharat on 10/13/14.
//  Copyright (c) 2014 BHN. All rights reserved.
//

#import "ResultsViewController.h"
#import "Utils.h"
#import "ResultsTableViewCell.h"

@interface ResultsViewController ()

@end

@implementation ResultsViewController

@synthesize results, menuVC, navController;

- (id)initWithNibName:(NSString *)nibNameOrNil bundle:(NSBundle *)nibBundleOrNil
{
    self = [super initWithNibName:nibNameOrNil bundle:nibBundleOrNil];
    if (self) {
        // Custom initialization
    }
    return self;
}

-(void)viewDidAppear:(BOOL)animated
{
    if (resultsTable)
    {
        [resultsTable reloadData];
    }
}

- (void)viewDidLoad
{
    [super viewDidLoad];
    
    
    CGRect screenRect = [[UIScreen mainScreen] bounds];
    screenWidth = screenRect.size.width;
    screenHeight = screenRect.size.height;
    
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
    
    [self.view setBackgroundColor:[Utils colorWithHexString:@"e8e8e8"]];
    
    resultsTable = [[UITableView alloc] initWithFrame:CGRectMake(0, screenHeight*0.2, screenWidth, screenHeight*0.7) style:UITableViewStylePlain];
    [resultsTable registerNib:[UINib nibWithNibName:@"ResultsTableViewCell" bundle:nil] forCellReuseIdentifier:@"ResultCell"];
    [resultsTable setSeparatorStyle:UITableViewCellSeparatorStyleNone];
    [resultsTable setDelegate:self];
    [resultsTable setDataSource:self];
    [self.view addSubview:resultsTable];
    
    blueLabels = [NSArray arrayWithObjects:@"N",@"P",@"K",@"Ca",@"Mg",@"S",@"Fe", @"Zn", @"Mn", @"Cu",@"B", nil];
    productLabels = [NSArray arrayWithObjects:@"SUPER NITRO®",@"SUPER PHOS®",@"SUPER K®",@"CALCIUM®",@"44 MAG®",@"SULFUR®",@"IRON®", @"Z-MAX®", @"MANGANESE®", @"COPPER®",@"BORON®", nil];
    
    titleLabel = [[UILabel alloc] initWithFrame:CGRectMake(0, 0, screenWidth*0.9, screenHeight*0.2)];
    titleLabel.text = @"Total Number of Gallons of HUMA GRO® Product Required";
    titleLabel.textColor = [Utils colorWithHexString:@"447fc2"];
    [titleLabel setTextAlignment:NSTextAlignmentCenter];
    [titleLabel setCenter:CGPointMake(screenWidth/2, screenHeight*0.12)];
    titleLabel.font = [UIFont systemFontOfSize:screenHeight*0.025];
    [titleLabel setLineBreakMode:NSLineBreakByWordWrapping];
    [titleLabel setNumberOfLines:0];
    [titleLabel sizeToFit];
    [self.view addSubview:titleLabel];
    
    subtitleLabel = [[UILabel alloc] initWithFrame:CGRectMake(0, 0, screenWidth*0.9, screenHeight*0.2)];
    subtitleLabel.text = @"Recommended Foliar Application Rate are given in ounces per Acre";
    subtitleLabel.textColor = [UIColor blackColor];
    [subtitleLabel setTextAlignment:NSTextAlignmentCenter];
    [subtitleLabel setCenter:CGPointMake(screenWidth/2, screenHeight*0.2)];
    subtitleLabel.font = [UIFont systemFontOfSize:screenHeight*0.02];
    [subtitleLabel setLineBreakMode:NSLineBreakByWordWrapping];
    [subtitleLabel setNumberOfLines:0];
    [subtitleLabel sizeToFit];
    [self.view addSubview:subtitleLabel];
    
    UIView *footerView = [[UIView alloc]initWithFrame:CGRectMake(0, 0, screenWidth, screenHeight*0.2)];
    //    [footerView setBackgroundColor:[UIColor grayColor]];
    
    UILabel *buttonLabel1 = [[UILabel alloc] initWithFrame:CGRectMake(0, 0, screenWidth*0.9, screenHeight*0.025)];
    [buttonLabel1 setTextAlignment:NSTextAlignmentCenter];
    [buttonLabel1 setText:@"1. Please save your calculation for future use."];
    [buttonLabel1 setCenter:CGPointMake(screenWidth/2, (footerView.frame.size.height/2)*0.3)];
    [buttonLabel1 setTextColor:[UIColor blackColor]];
    buttonLabel1.font = [UIFont systemFontOfSize:screenHeight*0.02];
    [buttonLabel1 setNumberOfLines:0];
    [footerView addSubview:buttonLabel1];
    
    UILabel *buttonLabel2 = [[UILabel alloc] initWithFrame:CGRectMake(0, 0, screenWidth*0.9, screenHeight*0.025)];
    [buttonLabel2 setTextAlignment:NSTextAlignmentCenter];
    [buttonLabel2 setText:@"2. Share your results."];
    [buttonLabel2 setCenter:CGPointMake(screenWidth/2, (footerView.frame.size.height/2)*0.6)];
    [buttonLabel2 setTextColor:[UIColor blackColor]];
    buttonLabel2.font = [UIFont systemFontOfSize:screenHeight*0.02];
    [buttonLabel2 setNumberOfLines:0];
    [footerView addSubview:buttonLabel2];
    
    saveButton = [[UIButton alloc]initWithFrame:CGRectMake(0, 0, 68, 45)];
    UIImage *saveButtonImage = [[UIImage imageNamed:@"save_button.png"]
                                resizableImageWithCapInsets:UIEdgeInsetsMake(18, 18, 18, 18)];
    [saveButton setBackgroundImage:saveButtonImage forState:UIControlStateNormal];
    [saveButton setCenter:CGPointMake((screenWidth/2) - 34, footerView.frame.size.height*2/3)];
    [saveButton addTarget:self action:@selector(saveResults) forControlEvents:UIControlEventTouchUpInside];
    [footerView addSubview:saveButton];
    
    shareButton = [[UIButton alloc]initWithFrame:CGRectMake(0, 0, 68, 45)];
    UIImage *shareButtonImage = [[UIImage imageNamed:@"share_button.png"]
                                resizableImageWithCapInsets:UIEdgeInsetsMake(18, 18, 18, 18)];
    [shareButton setBackgroundImage:shareButtonImage forState:UIControlStateNormal];
    [shareButton setCenter:CGPointMake((screenWidth/2) + 34, footerView.frame.size.height*2/3)];
    [shareButton addTarget:self action:@selector(shareResults) forControlEvents:UIControlEventTouchUpInside];
    [footerView addSubview:shareButton];
    
    resultsTable.tableFooterView = footerView;
    
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

-(void)back
{
    [self.navigationController popViewControllerAnimated:YES];
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

- (NSInteger)numberOfSectionsInTableView:(UITableView *)tableView
{
    return 1;
}

- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section
{
    return [blueLabels count];
}

- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath
{
    static NSString *cellIdentifier = @"ResultCell";
    ResultsTableViewCell *cell = (ResultsTableViewCell *)[tableView dequeueReusableCellWithIdentifier:cellIdentifier];
    
    // If there is no cell to reuse, create a new one
    if(cell == nil)
    {
        cell = [[ResultsTableViewCell alloc] initWithStyle:UITableViewCellStyleDefault reuseIdentifier:cellIdentifier];
    }
    
    cell.selectionStyle = UITableViewCellSelectionStyleNone;
    
    cell.blueLabel.text = [blueLabels objectAtIndex:indexPath.row];
    cell.productLabel.text = [productLabels objectAtIndex:indexPath.row];
    cell.resultLabel.text = [[self.results objectAtIndex:indexPath.row] stringValue];
    
    //alternate rows should be grey in color
    if ((indexPath.row)%2 != 0) {
        cell.backgroundColor = [Utils colorWithHexString:@"e8e8e8"];
    }
    
    return cell;
}

-(CGFloat)tableView:(UITableView *)tableView heightForRowAtIndexPath:(NSIndexPath *)indexPath
{
    return 34;
}

//- (CGFloat)tableView:(UITableView *)tableView heightForFooterInSection:(NSInteger)section
//{
//    return screenHeight*0.2;
//}

-(void)saveResults
{
    UIAlertView *alertView = [[UIAlertView alloc] initWithTitle:@"Save Results" message:@"Please enter a name for the file:" delegate:self cancelButtonTitle:@"Cancel" otherButtonTitles:@"Save", nil] ;
    alertView.tag = 1;
    alertView.alertViewStyle = UIAlertViewStylePlainTextInput;
    [alertView show];
    //[self showEmail];

}

-(void)shareResults
{
    /*UIAlertView *alertView = [[UIAlertView alloc] initWithTitle:@"Please provide a name for the file:" message:@"" delegate:self cancelButtonTitle:@"Cancel" otherButtonTitles:@"E-Mail", nil] ;
    alertView.tag = 2;
    alertView.alertViewStyle = UIAlertViewStylePlainTextInput;
    [alertView show];*/
    [self showEmail];
}

- (void)alertView:(UIAlertView *)alertView clickedButtonAtIndex:(NSInteger)buttonIndex
{
    NSString *fileName;
    
    if( buttonIndex == 1)
    {
        //get filename from user
        UITextField * alertTextField = [alertView textFieldAtIndex:0];
        NSLog(@"file name: %@",alertTextField.text);
        
        //get the documents directory:
        NSArray *paths = NSSearchPathForDirectoriesInDomains
        (NSDocumentDirectory, NSUserDomainMask, YES);
        NSString *documentsDirectory = [paths objectAtIndex:0];
        
        NSString *resultsDirectoryPath = [documentsDirectory stringByAppendingPathComponent:@"/results"];
        
        NSError *error;
        
        if (![[NSFileManager defaultManager] fileExistsAtPath:resultsDirectoryPath])
            [[NSFileManager defaultManager] createDirectoryAtPath:resultsDirectoryPath withIntermediateDirectories:NO attributes:nil error:&error];
        
        //make a file name to write the data to using the documents directory:
        fileName = [NSString stringWithFormat:@"%@/%@.json",
                              resultsDirectoryPath,alertTextField.text];
        
        NSLog(@"saving file: %@", fileName);
        
        //write content
        NSMutableDictionary *fileDict = [[NSMutableDictionary alloc]init];
        [fileDict setValue:productLabels forKey:@"productNames"];
        [fileDict setValue:results forKey:@"results"];

        NSData *jsonData = [NSJSONSerialization dataWithJSONObject:fileDict options:0 error:nil];
        
        // Checking the data
        NSLog(@"json data: %@",[[NSString alloc] initWithData:jsonData encoding:NSUTF8StringEncoding]);
        
        [jsonData writeToFile:fileName atomically:YES];
    }
}

- (void)showEmail {
    

    NSString *emailTitle = @"My BHN Test Results";
    NSString *messageBody = @"<table style=\"border-collapse:collapse;border-spacing:0\"><tr><th style=\"font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 20px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal\">SUPER NITRO®</th><th style=\"font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 20px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal\">1</th></tr><tr><td style=\"font-family:Arial, sans-serif;font-size:14px;padding:10px 20px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal\">SUPER PHOS®</td><td style=\"font-family:Arial, sans-serif;font-size:14px;padding:10px 20px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal\">2</td></tr><tr><td style=\"font-family:Arial, sans-serif;font-size:14px;padding:10px 20px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal\">SUPER K®</td><td style=\"font-family:Arial, sans-serif;font-size:14px;padding:10px 20px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal\">3</td></tr><tr><td style=\"font-family:Arial, sans-serif;font-size:14px;padding:10px 20px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal\">CALCIUM®</td><td style=\"font-family:Arial, sans-serif;font-size:14px;padding:10px 20px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal\">4</td></tr><tr><td style=\"font-family:Arial, sans-serif;font-size:14px;padding:10px 20px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal\">44 MAG®</td><td style=\"font-family:Arial, sans-serif;font-size:14px;padding:10px 20px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal\">5</td></tr><tr><td style=\"font-family:Arial, sans-serif;font-size:14px;padding:10px 20px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal\">SULFUR®</td><td style=\"font-family:Arial, sans-serif;font-size:14px;padding:10px 20px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal\">6</td></tr><tr><td style=\"font-family:Arial, sans-serif;font-size:14px;padding:10px 20px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal\">IRON®</td><td style=\"font-family:Arial, sans-serif;font-size:14px;padding:10px 20px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal\">7</td></tr><tr><td style=\"font-family:Arial, sans-serif;font-size:14px;padding:10px 20px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal\">Z-MAX®</td><td style=\"font-family:Arial, sans-serif;font-size:14px;padding:10px 20px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal\">8</td></tr><tr><td style=\"font-family:Arial, sans-serif;font-size:14px;padding:10px 20px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal\">MANGANESE®</td><td style=\"font-family:Arial, sans-serif;font-size:14px;padding:10px 20px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal\">9</td></tr><tr><td style=\"font-family:Arial, sans-serif;font-size:14px;padding:10px 20px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal\">COPPER®</td><td style=\"font-family:Arial, sans-serif;font-size:14px;padding:10px 20px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal\">10</td></tr><tr><td style=\"font-family:Arial, sans-serif;font-size:14px;padding:10px 20px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal\">BORON®</td><td style=\"font-family:Arial, sans-serif;font-size:14px;padding:10px 20px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal\">11</td></tr></table>";
    
    NSString *patternString;
    NSString *resultString;
    for (int i=0; i<[results count]; i++)
    {
        patternString = [NSString stringWithFormat:@">%d<",i+1];
        resultString = [NSString stringWithFormat:@">%@<",[results objectAtIndex:i]];
        messageBody = [messageBody stringByReplacingOccurrencesOfString:patternString withString:resultString];
    }
    
    NSArray *toRecipents = [NSArray arrayWithObject:@""];
    
    MFMailComposeViewController *mc = [[MFMailComposeViewController alloc] init];
    mc.mailComposeDelegate = self;
    [mc setSubject:emailTitle];
    [mc setMessageBody:messageBody isHTML:YES];
    [mc setToRecipients:toRecipents];
    
    // Determine the file name and extension
   // NSArray *filepart = [file componentsSeparatedByString:@"."];
   // NSString *filename = [filepart objectAtIndex:0];
   // NSString *extension = [filepart objectAtIndex:1];
    
    //NSLog(@"file name = %@ and extension = %@", filename, extension);
    
    // Get the resource path and read the file using NSData
    //NSString *filePath = [[NSBundle mainBundle] pathForResource:filename ofType:extension];
    //NSData *fileData = [NSData dataWithContentsOfFile:filePath];
    
    // Determine the MIME type
    /*NSString *mimeType;
    if ([extension isEqualToString:@"jpg"]) {
        mimeType = @"image/jpeg";
    } else if ([extension isEqualToString:@"png"]) {
        mimeType = @"image/png";
    } else if ([extension isEqualToString:@"doc"]) {
        mimeType = @"application/msword";
    } else if ([extension isEqualToString:@"ppt"]) {
        mimeType = @"application/vnd.ms-powerpoint";
    } else if ([extension isEqualToString:@"html"]) {
        mimeType = @"text/html";
    } else if ([extension isEqualToString:@"pdf"]) {
        mimeType = @"application/pdf";
    } else if ([extension isEqualToString:@"json"]) {
        NSLog(@"file extension was json");
        mimeType = @"text/plain";
    }*/
    
    // Add attachment
    //[mc addAttachmentData:fileData mimeType:mimeType fileName:filename];
    
    //just add
    
    
    
    // Present mail view controller on screen
    [self presentViewController:mc animated:YES completion:NULL];
    
}

- (void) mailComposeController:(MFMailComposeViewController *)controller didFinishWithResult:(MFMailComposeResult)result error:(NSError *)error
{
    switch (result)
    {
        case MFMailComposeResultCancelled:
            NSLog(@"Mail cancelled");
            break;
        case MFMailComposeResultSaved:
            NSLog(@"Mail saved");
            break;
        case MFMailComposeResultSent:
            NSLog(@"Mail sent");
            break;
        case MFMailComposeResultFailed:
            NSLog(@"Mail sent failure: %@", [error localizedDescription]);
            break;
        default:
            break;
    }
    
    // Close the Mail Interface
    [self dismissViewControllerAnimated:YES completion:NULL];
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
