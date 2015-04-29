//
//  CropDetails.h
//  BHN
//
//  Created by Rohit Kharat on 10/17/14.
//  Copyright (c) 2014 BHN. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface CropDetails : NSObject

@property (nonatomic, strong) NSString *cropType;
@property (nonatomic, strong) NSNumber *growthStage;
@property (nonatomic, strong) NSNumber *N;
@property (nonatomic, strong) NSNumber *P;
@property (nonatomic, strong) NSNumber *K;
@property (nonatomic, strong) NSNumber *Ca;
@property (nonatomic, strong) NSNumber *Mg;
@property (nonatomic, strong) NSNumber *S;
@property (nonatomic, strong) NSNumber *Fe;
@property (nonatomic, strong) NSNumber *Zn;
@property (nonatomic, strong) NSNumber *Mn;
@property (nonatomic, strong) NSNumber *Cu;
@property (nonatomic, strong) NSNumber *B;

- (id)initWithCropType:(NSString*)croptype andGrowthStage:(NSNumber*)growthstage andN:(NSNumber*)n  andP:(NSNumber*)p andK:(NSNumber*)k andCa:(NSNumber*)ca andMg:(NSNumber*)mg andS:(NSNumber*)s andFe:(NSNumber*)fe andZn:(NSNumber*)zn andMn:(NSNumber*)mn andCu:(NSNumber*)cu andB:(NSNumber*)b;

@end
