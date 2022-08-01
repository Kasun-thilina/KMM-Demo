import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Planet(
    @SerialName("name") var name: String? = null,
    @SerialName("rotation_period") var rotationPeriod: String? = null,
    @SerialName("orbital_period") var orbitalPeriod: String? = null,
    @SerialName("diameter") var diameter: String? = null,
    @SerialName("climate") var climate: String? = null,
    @SerialName("gravity") var gravity: String? = null,
    @SerialName("terrain") var terrain: String? = null,
    @SerialName("surface_water") var surfaceWater: String? = null,
    @SerialName("created") var created: String? = null,
    @SerialName("url") var url: String? = null,
)
