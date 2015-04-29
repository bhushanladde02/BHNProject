//
//  CropDetails.m
//  BHN
//
//  Created by Rohit Kharat on 10/17/14.
//  Copyright (c) 2014 BHN. All rights reserved.
//

#import "CropDetails.h"

@implementation CropDetails

@synthesize cropType, growthStage, N, P, K, Ca, Mg, S, Fe, Zn, Mn, Cu, B;

- (id)initWithCropType:(NSString*)croptype andGrowthStage:(NSNumber*)growthstage andN:(NSNumber*)n  andP:(NSNumber*)p andK:(NSNumber*)k andCa:(NSNumber*)ca andMg:(NSNumber*)mg andS:(NSNumber*)s andFe:(NSNumber*)fe andZn:(NSNumber*)zn andMn:(NSNumber*)mn andCu:(NSNumber*)cu andB:(NSNumber*)b
{
    self = [super init];
    if(self) {
        self.cropType = croptype;
        self.growthStage = growthstage;
        self.N = n;
        self.P = p;
        self.K = k;
        self.Ca = ca;
        self.Mg = mg;
        self.S = s;
        self.Fe = fe;
        self.Zn = zn;
        self.Mn = mn;
        self.Cu = cu;
        self.B = b;
        
    }
    return self;
}

@end
