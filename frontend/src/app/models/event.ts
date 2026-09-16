export interface Event {
    id: string;
    tite: string;
    leadText?: string;
    coverUrl: string;
    dateStart: string;
    dateEnd?: string;
    adressName?: string;
    adressStreet?: string;
    adressZipcode?: string;
    adressCity?: string;
    priceType?: string;
}
