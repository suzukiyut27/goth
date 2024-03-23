import Foundation
import ComposeApp

func startKoin() {
    KoinKt.startKoin()
}

func get<T>() -> T {
    return KoinResolver.shared.resolve(objCObject: T.self) as! T
}
