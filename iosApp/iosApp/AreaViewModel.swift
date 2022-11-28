import Foundation
import SwiftUI
import Combine
import KMPNativeCoroutinesCore
import KMPNativeCoroutinesCombine

import shared


class ViewModel: ObservableObject {
    static let initialWidth = 2.0
    static let initialHeight = 3.0
    
    @Published public var width = initialWidth
    @Published public var height = initialHeight
    @Published public var area: Double?
    
    var subscriptions = Set<AnyCancellable>()
    
    
    init() {
        let calculation = AreaCalculationNative()
        
        func setWidth(value: Double) { calculation.setWidth(value: value) }
        func setHeight(value: Double) { calculation.setHeight(value: value) }

        createPublisher(for: calculation.areaNative)
            .catch { _ in Empty<KotlinFloat, Never>() }
            .map(Double.init)
            .receive(on: DispatchQueue.main)
            .assign(to: &$area)

        $width
            .sink(receiveValue: setWidth)
            .store(in: &self.subscriptions)

        $height
            .sink(receiveValue: setHeight)
            .store(in: &self.subscriptions)
    }
}

