import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RecargaService {
  private apiUrl = 'http://localhost:8080/api/recargas';

  constructor(private http: HttpClient) { }

  postRecarga(recargaData: any): Observable<any> {
    return this.http.post(this.apiUrl, recargaData);
  }

}
