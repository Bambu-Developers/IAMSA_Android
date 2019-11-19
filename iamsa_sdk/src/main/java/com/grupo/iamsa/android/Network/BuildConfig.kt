package com.grupo.iamsa.android.Network


object  BuildConfig {

    var aplicationType = Enterprise.ETN

}

enum class Enterprise {

    ETN{
        override fun urlViajaMas(): String { return "http://201.131.2.199/portalmultiventaws/PortalMultiventaWS.asmx" }
        override fun user(): String { return "APPVJM"}
        override fun password(): String { return "TESTVJM"}
    },

    CostaLine{
        override fun urlViajaMas(): String { return "http://201.131.2.199/portalmultiventaws/PortalMultiventaWS.asmx" }
        override fun user(): String { return "APPVJM"}
        override fun password(): String { return "TESTVJM"}
    };

    abstract fun urlViajaMas(): String
    abstract fun user(): String
    abstract fun password():String
}