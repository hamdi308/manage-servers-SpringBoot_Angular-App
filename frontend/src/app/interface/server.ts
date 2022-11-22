import { Status } from "../enum/status.enum";

export interface Server{
    id: number,
    ipAdresse: string,
    name: string,
    memory: string,
    type: string,
    imageUrl: string,
    status:Status
}