import kotlinx.cinterop.BetaInteropApi
import kotlinx.cinterop.ObjCClass
import kotlinx.cinterop.ObjCProtocol
import kotlinx.cinterop.getOriginalKotlinClass
import org.koin.core.component.KoinComponent


@OptIn(BetaInteropApi::class)
@Suppress("unused")
object KoinResolver : KoinComponent {


    fun resolve(objCObject: Any): Any {
        if (objCObject is ObjCProtocol) {
            return resolve(objCProtocol = objCObject)
        }
        if (objCObject is ObjCClass) {
            return resolve(objCClass = objCObject)
        }
        throw Exception(message = "Unknown Object Type.")
    }

    private fun resolve(objCClass: ObjCClass): Any = getKoin().get(
        clazz = getOriginalKotlinClass(objCClass = objCClass)!!
    )

    private fun resolve(objCProtocol: ObjCProtocol): Any = getKoin().get(
        clazz = getOriginalKotlinClass(objCProtocol = objCProtocol)!!
    )
}