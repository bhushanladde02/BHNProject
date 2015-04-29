//
//  ProductTableViewCell.h
//  BHN
//
//  Created by William Grey on 7/30/14.
//  Copyright (c) 2014 BHN. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface ProductTableViewCell : UITableViewCell <UIDocumentInteractionControllerDelegate>
@property (weak, nonatomic) IBOutlet UILabel *firstLabel;
@property (weak, nonatomic) IBOutlet UIButton *labelButton;
@property (weak, nonatomic) IBOutlet UIButton *sdsButton;
@property (nonatomic, retain) UIView *parentView;

@property UIDocumentInteractionController *documentInteractionController;

@property (nonatomic, retain) NSString *labelUrl;
@property (nonatomic, retain) NSString *sdsUrl;

-(void) setFirstColumnName:(NSString *)name;
- (IBAction)labelClicked:(id)sender;
- (IBAction)sdsClicked:(id)sender;

@end
