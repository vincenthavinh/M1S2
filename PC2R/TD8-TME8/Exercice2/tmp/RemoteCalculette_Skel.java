// Skel class generated by rmic - DO NOT EDIT!

public final class RemoteCalculette_Skel
    implements java.rmi.server.Skeleton
{
    private static final long interfaceHash = 266392L;
    
    private static final java.rmi.server.Operation[] operations = {
        new java.rmi.server.Operation("void cumuler(java.lang.Integer"),
        new java.rmi.server.Operation("java.lang.Integer eval(java.lang.Integer, java.lang.Integer"),
        new java.rmi.server.Operation("java.lang.Integer getCumul("),
        new java.rmi.server.Operation("void resetCumul(")
    };
    
    public java.rmi.server.Operation[] getOperations() {
        return ((java.rmi.server.Operation[]) operations.clone());
    }
    
    public void dispatch(java.rmi.Remote obj, java.rmi.server.RemoteCall call, int opnum, long hash) throws java.lang.Exception {
        if (opnum < 0) {
            if (hash == 2037129987253436966L) {
                opnum = 0;
            }
            else if (hash == -2297158981752979836L) {
                opnum = 1;
            }
            else if (hash == 6266889176079361830L) {
                opnum = 2;
            }
            else if (hash == 5887732619929798478L) {
                opnum = 3;
            }
            else {
                throw new java.rmi.server.SkeletonMismatchException("interface hash mismatch");
            }
        }
        else if (hash != interfaceHash) {
            throw new java.rmi.server.SkeletonMismatchException("interface hash mismatch");
        }
        
        RemoteCalculette server = (RemoteCalculette)obj;
        switch (opnum) {
        case 0:
        {
            java.lang.Integer $param_0;
            try {
                java.io.ObjectInput in = call.getInputStream();
                $param_0 = (java.lang.Integer)in.readObject();
                
            }
            catch (java.io.IOException e) {
                throw new java.rmi.UnmarshalException("error unmarshalling arguments", e);
            }
            catch (java.lang.ClassCastException e) {
                throw new java.rmi.UnmarshalException("error unmarshalling arguments", e);
            }
            finally {
                call.releaseInputStream();
            }
            server.cumuler($param_0);
            try {
                java.io.ObjectOutput out = call.getResultStream(true);
            }
            catch (java.io.IOException e) {
                throw new java.rmi.MarshalException("error marshalling return", e);
            }
            break;
        }
        
        case 1:
        {
            java.lang.Integer $param_0;
            java.lang.Integer $param_1;
            try {
                java.io.ObjectInput in = call.getInputStream();
                $param_0 = (java.lang.Integer)in.readObject();
                $param_1 = (java.lang.Integer)in.readObject();
                
            }
            catch (java.io.IOException e) {
                throw new java.rmi.UnmarshalException("error unmarshalling arguments", e);
            }
            catch (java.lang.ClassCastException e) {
                throw new java.rmi.UnmarshalException("error unmarshalling arguments", e);
            }
            finally {
                call.releaseInputStream();
            }
            java.lang.Integer $result = server.eval($param_0, $param_1);
            try {
                java.io.ObjectOutput out = call.getResultStream(true);
                out.writeObject($result);
            }
            catch (java.io.IOException e) {
                throw new java.rmi.MarshalException("error marshalling return", e);
            }
            break;
        }
        
        case 2:
        {
            try {
                java.io.ObjectInput in = call.getInputStream();
                
            }
            catch (java.io.IOException e) {
                throw new java.rmi.UnmarshalException("error unmarshalling arguments", e);
            }
            finally {
                call.releaseInputStream();
            }
            java.lang.Integer $result = server.getCumul();
            try {
                java.io.ObjectOutput out = call.getResultStream(true);
                out.writeObject($result);
            }
            catch (java.io.IOException e) {
                throw new java.rmi.MarshalException("error marshalling return", e);
            }
            break;
        }
        
        case 3:
        {
            try {
                java.io.ObjectInput in = call.getInputStream();
                
            }
            catch (java.io.IOException e) {
                throw new java.rmi.UnmarshalException("error unmarshalling arguments", e);
            }
            finally {
                call.releaseInputStream();
            }
            server.resetCumul();
            try {
                java.io.ObjectOutput out = call.getResultStream(true);
            }
            catch (java.io.IOException e) {
                throw new java.rmi.MarshalException("error marshalling return", e);
            }
            break;
        }
        
        default:
            throw new java.rmi.UnmarshalException("invalid method number");
        }
    }
}