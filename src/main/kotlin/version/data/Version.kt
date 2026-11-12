package version.data

data class Version(
    val versionId: String,
    val classes: List<Class>,
    val primitives: List<Class>,
    val singletons: List<Class>,
    val globals: List<Class>
) {
    val classNames: Set<String> by lazy {
        (singletons + classes - primitives).mapTo(mutableSetOf()) { it.name }
    }

    val globalConstantNames: Set<String> by lazy {
        globals.asSequence().flatMap { it.constants.asSequence() }.mapTo(mutableSetOf()) { it.name }
    }
}
