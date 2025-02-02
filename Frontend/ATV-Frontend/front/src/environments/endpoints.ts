import { environment } from './environment';

export const Endpoints = {
  security: {
    login: `${environment.baseUrl}/login?delay=2`,
  },
  demo: {
    colors: `${environment.baseUrl}/unknown`,
  },
  users: {
    users: `${environment.baseUrl}/users`,
    userByBranch: `${environment.baseUrl}/branchbyuser`,
    usersByProduct: `${environment.baseUrl}/productbyuser`,
    // http://localhost:9090 + /users -> http://localhost:9090/users
  },
  branch: {
    branches: `${environment.baseUrl}/branch`
  },
  product: {
    products: `${environment.baseUrl}/productdocument`
  },
  positions: {
    positions: `${environment.baseUrl}/positions`,
  },
  domains: {
    domains: `${environment.baseUrl}/domains`,
  },
  access: {
    access: `${environment.baseUrl}/access`,
  },
};

export const TokenExcludedEndpoints = ['login'];
