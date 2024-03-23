import UIKit
import SwiftUI
import ComposeApp

struct ComposeView: UIViewControllerRepresentable {
    private let store = MainStore(middleware: get(), reducer: get())
    func makeUIViewController(context: Context) -> UIViewController {
        store.dispatch(action: MainActionFetchItems(keyword: "楽天"))
        return MainViewControllerKt.MainViewController(store: store)
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
    
    func dismantleUIViewController(_ uiViewController: UIViewController, coordinator: ()) {
        store.dispatch(action: MainActionCancelScope())
    }
}

struct ContentView: View {
    var body: some View {
        ComposeView()
                .ignoresSafeArea(.keyboard) // Compose has own keyboard handler
    }
}



