export class LoginResponse{
    constructor(
        public  username : string ="?",
        public  ok : boolean = false,
        public  message : string ="?",
        public  token : string ="?" ){}
}