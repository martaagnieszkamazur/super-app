import androidx.navigation3.runtime.NavKey
import androidx.savedstate.serialization.SavedStateConfiguration
import kotlinx.serialization.Serializable
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic

object Route {

    @Serializable
    object Main : NavKey

    @Serializable
    object StepsCounter : NavKey

    @Serializable
    object Test: NavKey

    @Serializable
    sealed interface StepsCounterNav : NavKey {

        @Serializable
        object Home : StepsCounterNav

        @Serializable
        object Journal : StepsCounterNav

        @Serializable
        object Profile : StepsCounterNav

        @Serializable
        object AddSteps: StepsCounterNav
    }

    val config = SavedStateConfiguration {
        serializersModule = SerializersModule {
            polymorphic(NavKey::class) {
                subclass(Main::class, Main.serializer())
                subclass(StepsCounter::class, StepsCounter.serializer())
                subclass(Test::class, Test.serializer())
                subclass(StepsCounterNav.Home::class, StepsCounterNav.Home.serializer())
                subclass(StepsCounterNav.Journal::class, StepsCounterNav.Journal.serializer())
                subclass(StepsCounterNav.Profile::class, StepsCounterNav.Profile.serializer())
                subclass(StepsCounterNav.AddSteps::class, StepsCounterNav.AddSteps.serializer())
            }
        }
    }
}