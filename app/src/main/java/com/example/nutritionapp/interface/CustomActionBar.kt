import androidx.fragment.app.Fragment

interface CustomActionBar {
    var visibilityCustomActionBar:Boolean
    fun getTitle() : String?
    fun getBack(): Fragment?
}