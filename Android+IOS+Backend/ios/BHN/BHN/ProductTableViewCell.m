//
//  ProductTableViewCell.m
//  BHN
//
//  Created by William Grey on 7/30/14.
//  Copyright (c) 2014 BHN. All rights reserved.
//

#import "ProductTableViewCell.h"
#import "AFHTTPRequestOperation.h"

@implementation ProductTableViewCell

@synthesize labelUrl,sdsUrl,parentView;

- (void)awakeFromNib
{
    
    
    CGFloat winHeight = [[UIScreen mainScreen] bounds].size.height;
    CGFloat winWidth = [[UIScreen mainScreen] bounds].size.width;
    
    self.frame = CGRectMake(0, 0, winWidth, winHeight);
    // Initialization code
}

- (void)setSelected:(BOOL)selected animated:(BOOL)animated
{
    [super setSelected:selected animated:animated];

    // Configure the view for the selected state
}


-(void) setFirstColumnName:(NSString *)name
{
    self.firstLabel.text = name;
}

- (IBAction)labelClicked:(id)sender {
    NSURLRequest *request = [NSURLRequest requestWithURL:[NSURL URLWithString:labelUrl]];
    AFHTTPRequestOperation *operation = [[AFHTTPRequestOperation alloc] initWithRequest:request];
    
    NSArray *paths = NSSearchPathForDirectoriesInDomains(NSDocumentDirectory, NSUserDomainMask, YES);
    NSString *path = [[paths objectAtIndex:0] stringByAppendingPathComponent:@"filename1.jpg"];
    operation.outputStream = [NSOutputStream outputStreamToFileAtPath:path append:NO];
    
    [operation setCompletionBlockWithSuccess:^(AFHTTPRequestOperation *operation, id responseObject) {
        NSLog(@"Successfully downloaded file to %@", path);
        
        NSURL *URL = [NSURL fileURLWithPath:path];
        if (URL)
        {
            _documentInteractionController = [UIDocumentInteractionController interactionControllerWithURL:URL];
            _documentInteractionController.delegate = self;
            
            // Present "Open In Menu"
            [_documentInteractionController presentOpenInMenuFromRect:CGRectMake(self.parentView.frame.size.width/2, self.parentView.frame.size.height/2, self.parentView.frame.size.width/2, self.parentView.frame.size.height/2) inView:parentView animated:YES];
        }
        
        
        
    } failure:^(AFHTTPRequestOperation *operation, NSError *error) {
        NSLog(@"Error: %@", error);
    }];
    
    [operation start];

}

- (IBAction)sdsClicked:(id)sender {
    NSURLRequest *request = [NSURLRequest requestWithURL:[NSURL URLWithString:sdsUrl]];
    AFHTTPRequestOperation *operation = [[AFHTTPRequestOperation alloc] initWithRequest:request];
    
    NSArray *paths = NSSearchPathForDirectoriesInDomains(NSDocumentDirectory, NSUserDomainMask, YES);
    NSString *path = [[paths objectAtIndex:0] stringByAppendingPathComponent:@"filename.pdf"];
    operation.outputStream = [NSOutputStream outputStreamToFileAtPath:path append:NO];
    
    [operation setCompletionBlockWithSuccess:^(AFHTTPRequestOperation *operation, id responseObject) {
        NSLog(@"Successfully downloaded file to %@", path);
        
        NSURL *URL = [NSURL fileURLWithPath:path];
        if (URL)
        {
            _documentInteractionController = [UIDocumentInteractionController interactionControllerWithURL:URL];
            _documentInteractionController.delegate = self;
            
            // Present "Open In Menu"
            [_documentInteractionController presentOpenInMenuFromRect:CGRectMake(self.parentView.frame.size.width/2, self.parentView.frame.size.height/2, self.parentView.frame.size.width/2, self.parentView.frame.size.height/2) inView:parentView animated:YES];
        }
        
        
    } failure:^(AFHTTPRequestOperation *operation, NSError *error) {
        NSLog(@"Error: %@", error);
    }];
    
    [operation start];
}

@end
