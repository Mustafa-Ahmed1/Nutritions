import androidx.fragment.app.Fragment

interface CustomActionBar {
    var statesCustomActionBar:Boolean
    fun title() : String?
    fun back(): Fragment?
}