import androidx.fragment.app.Fragment

interface CustomActionBar {
    var visibilityCustomActionBar:Boolean
    fun title() : String?
    fun back(): Fragment?
}