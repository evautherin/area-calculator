import SwiftUI

struct ContentView: View {
    @StateObject private var viewModel = ViewModel()

    var body: some View {
        VStack {
            LengthView(label: "Width", sliderValue: $viewModel.width)
            LengthView(label: "Height", sliderValue: $viewModel.height)
            viewModel.area.map {
                Text("Area: \($0)").padding()
            }
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}

