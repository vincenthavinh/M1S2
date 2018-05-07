/*
 * Please do not edit this file.
 * It was generated using rpcgen.
 */

#include <memory.h> /* for memset */
#include "calcul.h"

/* Default timeout can be changed using clnt_control() */
static struct timeval TIMEOUT = { 25, 0 };

void *
calcul_null_1(void *argp, CLIENT *clnt)
{
	static char clnt_res;

	memset((char *)&clnt_res, 0, sizeof(clnt_res));
	if (clnt_call (clnt, CALCUL_NULL,
		(xdrproc_t) xdr_void, (caddr_t) argp,
		(xdrproc_t) xdr_void, (caddr_t) &clnt_res,
		TIMEOUT) != RPC_SUCCESS) {
		return (NULL);
	}
	return ((void *)&clnt_res);
}

reponse *
calcul_addition_1(data *argp, CLIENT *clnt)
{
	static reponse clnt_res;

	memset((char *)&clnt_res, 0, sizeof(clnt_res));
	if (clnt_call (clnt, CALCUL_ADDITION,
		(xdrproc_t) xdr_data, (caddr_t) argp,
		(xdrproc_t) xdr_reponse, (caddr_t) &clnt_res,
		TIMEOUT) != RPC_SUCCESS) {
		return (NULL);
	}
	return (&clnt_res);
}
