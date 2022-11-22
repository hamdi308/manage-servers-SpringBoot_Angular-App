import { HttpClient } from '@angular/common/http';
import { catchError, Observable, tap, throwError } from 'rxjs';
import { CustomResponse } from '../interface/custom-response';
import { Server } from '../interface/server';
export class ServerService {

  private readonly apiUrl = 'any';
  constructor(private http: HttpClient) { }
  servers$ = <Observable<CustomResponse>>this.http.get<CustomResponse>(`${this.apiUrl}/server/list`).pipe(tap(console.log), catchError(this.handleError))
  save$ = (server: Server) => { <Observable<CustomResponse>> this.http.post<CustomResponse>(`${this.apiUrl}/server/save`,server).pipe(tap(console.log), catchError(this.handleError)) };
  handleError(handleError: any): Observable<never> {
    return throwError(() => 'Method not implemented.') ;
  }
}
