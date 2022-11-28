//
//  CalculationIntent.swift
//  iosApp
//
//  Created by Etienne Vautherin on 20/11/2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import AppIntents
import KMPNativeCoroutinesCore
import KMPNativeCoroutinesAsync
import shared

struct CalculationIntent: AppIntent {
    static let title: LocalizedStringResource = "Calculate Area"

    @Parameter(title: "Width")
    var width: Double

    @Parameter(title: "Heigth")
    var height: Double
    
    func perform() async throws -> some IntentResult {
        let calculation = AreaCalculationNative()
        
        async let area = try await asyncFunction(for: calculation.asyncAreaNative())
        calculation.setWidth(value: width)
        calculation.setHeight(value: height)
        return .result(value: Double(truncating: try await area))
    }
}

