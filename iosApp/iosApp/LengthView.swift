import SwiftUI


struct LengthView: View {
    var label: String
    @Binding var sliderValue: Double

    var body: some View {
        VStack {
            Text("\(label): \(sliderValue)")
            Slider(value: $sliderValue, in: 1.0...10.0)
        }
        .padding()
    }
}

struct LengthView_Previews: PreviewProvider {
    static var previews: some View {
        LengthView(label: "Value", sliderValue: .constant(3.0))
    }
}
