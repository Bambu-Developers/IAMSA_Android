package com.grupo.iamsa.android.Network.API



enum class APIMethod {
    register{
        override fun path(): String {
            return "portalmultiventaws/PortalMultiventaWS.asmx"
        }

        override fun SOAPAction(): String {
            return "http://PortalMultiventaWS.org/Crea_ActualizaInterlocutorComer"
        }
    },
    login{
        override fun path(): String {
            return "portalmultiventaws/PortalMultiventaWS.asmx"
        }

        override fun SOAPAction(): String {
            return "http://PortalMultiventaWS.org/LecturaInterlocutor"
        }
    };

    abstract fun path(): String
    abstract fun SOAPAction():String
}

