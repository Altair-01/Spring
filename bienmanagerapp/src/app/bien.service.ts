import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { HttpClient } from '@angular/common/http';
import { Bien } from "./bien";
import { environment } from "src/environments/environment";

@Injectable({
    providedIn:'root'
})
export class BienService {
    private apiServerUrl = environment.apiBaseUrl;
    constructor (private http: HttpClient ) {}

    public getBiens(): Observable<Bien[]> {
        return this.http.get<Bien[]>(`${this.apiServerUrl}/api/v1/bien`);
    }

    public addBien(bien:Bien): Observable<Bien> {
        return this.http.post<Bien>(`${this.apiServerUrl}/api/v1/bien`, bien);
    }

    public updateBiens(bien:Bien): Observable<Bien> {
        return this.http.put<Bien>(`${this.apiServerUrl}/api/v1/bien`, bien);
    }

    public deleteBiens(bienId:number): Observable<void> {
        return this.http.delete<void>(`${this.apiServerUrl}/api/v1/bien/${bienId}`);
    }

}