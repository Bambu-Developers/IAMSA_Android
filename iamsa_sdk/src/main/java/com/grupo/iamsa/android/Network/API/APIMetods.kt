package com.grupo.iamsa.android.Network.API



enum class APIMethod {
    register{
        override fun SOAPAction(): String { return "http://PortalMultiventaWS.org/Crea_ActualizaInterlocutorComer" }
    },
    login{
        override fun SOAPAction(): String { return "http://PortalMultiventaWS.org/LecturaInterlocutor" }
    },
    recoverAccount {
        override fun SOAPAction(): String { return "http://PortalMultiventaWS.org/RecuperacionContrasena" }
    },
    chanePassword {
        override fun SOAPAction(): String { return "http://PortalMultiventaWS.org/getCambioContrasena" }
    };



    abstract fun SOAPAction():String
}

