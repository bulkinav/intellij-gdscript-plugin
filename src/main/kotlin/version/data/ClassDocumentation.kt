package version.data

data class ClassDocumentation(
    val description: String,
    val fields: Map<String, String>,
    val methods: Map<String, String>
)
